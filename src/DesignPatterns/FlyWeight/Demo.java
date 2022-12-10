package DesignPatterns.FlyWeight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

class User {
    private String fullName;
    public User(String fullName) {
        this.fullName = fullName;
    }
}

class User2 {
    static List<String> strings = new ArrayList<>();
    public int[] names;

    public User2(String fullName) {
        Function<String, Integer> getOrAdd = (String s) -> {
            int idx = strings.indexOf(s);
            if(idx != -1) {
                return idx;
            }
            else {
                strings.add(s);
                return strings.size()-1;
            }
        };
        names = Arrays.stream(fullName.split(" ")).mapToInt(getOrAdd::apply).toArray();

    }
}

public class Demo {
    public static void main(String[] args) {
        User2 user = new User2("John Smith");
        User2 user2 = new User2("Jane Smith");

        System.out.println(user.names[0]+"\t"+user.names[1] + "\t" + user2.names[0] + "\t" + user2.names[1]);

        // if we are using UTF8 we are wasting 5 bytes
        // flyweight is space optimization techinique which helps
        // us to store large quantity of similar objects

    }
}