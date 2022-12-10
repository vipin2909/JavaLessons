package DesignPatterns.Factory;//package DesignPatterns.Factory;
//
//import java.util.ArrayList;
//import java.util.Set;
//
//interface HotDrink {
//    void consume();
//}
//
//class Tea implements HotDrink {
//    @Override
//    public void consume() {
//        System.out.println("This tea is delecious");
//    }
//}
//
//class Coffee implements HotDrink {
//    @Override
//    public void consume() {
//        System.out.println("This Coffee is Delecious");
//    }
//}
//
//interface HotDrinkFactory {
//    HotDrink prepare(int amount);
//}
//
//class TeaFactory implements HotDrinkFactory {
//    @Override
//    public HotDrink prepare(int amount) {
//        System.out.println("Put in Tea bag, boli water, pour " + amount + "ml, add lemon, enjoy!");
//        return new Tea();
//    }
//}
//
//class CoffeeFactory implements HotDrinkFactory {
//    @Override
//    public HotDrink prepare(int amount) {
//        System.out.println("Grind some beans, boil water, pour "+amount+"ml add cream and sugar, enojy!");
//        return new Coffee();
//    }
//}
//
//class HotDrinkMachine throws Exception {
//    private List<Pair<String, HotDrinkFactory>> namedFactorie = new ArrayList<>();
//
////    public HotDrinkMachine() {
////        Set<Class<? extends HotDrinkFactory>> types = new Reflections("").getSubTypesOf(HotDrinkFactory.class);
////        for(Class<? extends HotDrinkFactory> type: types) {
////            namedFactorie.add(new Pair<>(
////               type.getSimpleName().replace("Factory", ""),
////               type.getDeclaredConstructor().newInstance()
////            ));
////        }
////    }
//
//    public HotDrink makeDrink() throws Exception {
//
//        }
//}
//
//
//
//
//public class Main {
//
//}
//


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}