package DesignPatterns.Proxy;


class Property<T> {
    private T value;

    public Property(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {

        // logging
        // globally configuring
        // in dependency injection you get some default
        // values injected in the class
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) {
            return false;
        }
        Property<?> property = (Property<?>) o;
        return value != null ? value.equals(property.value) : property.value == value;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

}
class Creature {
//    private int agility;
//
//    public Creature() {
//        agility = 123;
//    }
//
//    public int getAgility() {
//        return agility;
//    }
//
//    public void setAgility(int agility) {
//        this.agility = agility;
//    }

    private Property<Integer> agility = new Property<>(10);

    // this example is used to prevent the
    // agility = 122;
    // because it is not good practice
    public void setAgility(int value) {
        agility.setValue(value);
    }
    public int getAgility() {
        return agility.getValue();
    }

}
public class PropertyProxy {
    public static void main(String[] args) {
        Creature creature = new Creature();
        creature.setAgility(12);
    }
}