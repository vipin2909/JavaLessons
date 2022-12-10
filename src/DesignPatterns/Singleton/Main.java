package DesignPatterns.Singleton;


// For Some Components it only makes sense to have one in the system
// - Database repository
// - Object Factory

// Eg. the constructor call is expensive
// - we do it only once
// - we provide everyone with the same instance

// Want to prevent anyone creating additional copies
// Need to take care of lazy instantiation and thread safety


// Singleton -> A Component which is only instantiated once


import java.io.*;

class BasicSingleton implements Serializable {
    private BasicSingleton() {

    }
    private static final BasicSingleton INSTANCE = new BasicSingleton();
    public static BasicSingleton getInstance() {
        return INSTANCE;
    }

    private int value = 0;

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }

    @Serial
    protected Object readResolve() {
        return INSTANCE;
    }
}
public class Main {

    static void saveToFile(BasicSingleton singleton, String fileName) throws Exception {

        try (FileOutputStream fileOut = new FileOutputStream(fileName); ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(singleton);
        }

    }
    static BasicSingleton readFromFile(String fileName) throws Exception {
        try(FileInputStream fileIn = new FileInputStream(fileName); ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return (BasicSingleton)in.readObject();
        }
    }
    public static void main(String[] args)  throws Exception {

        // the below code is of basic singleton
//        BasicSingleton singleton = BasicSingleton.getInstance();
//        singleton.setValue(123);
//        System.out.println(singleton.getValue());

        // we can use reflection to get to this constructor
        // can make new instances of this constructor
        // 1. Reflection
        // 2. Serialization

        BasicSingleton singleton = BasicSingleton.getInstance();
        singleton.setValue(111);

        String fileName = "singleton.bin";
        saveToFile(singleton, fileName);
        singleton.setValue(222);
        BasicSingleton singleton2 = readFromFile(fileName);

        System.out.println(singleton == singleton2);
        System.out.println(singleton.getValue());
        System.out.println(singleton2.getValue());

    }
}