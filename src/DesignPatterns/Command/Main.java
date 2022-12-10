package DesignPatterns.Command;

import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> hell = new java.util.ArrayList<>(List.of(1, 2, 3, 4, 5));
        Collections.reverse(hell);
        for(Integer i: hell) {
            System.out.print(i+"\t");
        }
        System.out.println();
    }
}