package DesignPatterns.Builder;

// best example of recursive generics
import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

abstract class Pizza {
    public enum Topping {
        HAM, MUSHROOM, ONION, PEPPER, SAUSAGE
    }

    // this is to avoid repetative adding of toppings
    final Set<Topping>  toppings;

    abstract  static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        public T addTopping(Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }
        abstract Pizza build();

        // subclass must override this method to return this;
        protected abstract T self();
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }
}

class NyPizza extends Pizza {
    public enum Size {
        SMALL,
        MEDIUM,
        LARGE
    }
    private final Size size;
    public static class  Builder extends Pizza.Builder<Builder> {
        private final Size size;
        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }
        @Override
        public NyPizza build() {
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }
    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }
}

class CalZone extends Pizza {
    private final boolean sauseInside;
    public static class Builder extends Pizza.Builder<Builder> {
        private boolean sauseInside = false;
        public Builder sauseInside() {
            this.sauseInside = true;
            return this;
        }
        @Override
        public CalZone build() {
            return new CalZone(this);
        }
        @Override
        protected Builder self() {
            return this;
        }
    }
    private CalZone(Builder builder) {
        super(builder);
        sauseInside = builder.sauseInside;
    }
}
public class PizzaTest {
    public static void main(String[] args) {
        CalZone calzone = new CalZone.Builder().addTopping(Pizza.Topping.MUSHROOM).sauseInside().build();
        System.out.println(calzone.toppings);

//        Pizza pizza = calzone;
//        System.out.println(pizza.toppings);
//
//        NyPizza nyPizza = (NyPizza) pizza;
//        System.out.println(nyPizza.toppings);
    }
}
