package DesignPatterns.Observer;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class JavaConsumer {

    // Consumer does not return anything it just accept something and perform
    // some operation using accept method

    public static void main(String[] args) {
        Consumer<Integer> display = a -> System.out.println(a);
        display.accept(10);
        // Consumer to multiply every integer of a list by 2
        Consumer<List<Integer>> modify = list -> {
            for(int i = 0; i < list.size(); i++) {
                list.set(i, 2 * list.get(i));
            }
        };
        // Consumer to display a list of numbers
        Consumer<List<Integer>> displayList = list -> list.stream().forEach(a -> System.out.print(a+" "));

        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(3);

        // Implement modify using accept()
        modify.accept(list);

        // Implement dispList using accept()
        displayList.accept(list);


    }
}
