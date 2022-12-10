package DesignPatterns.Singleton;

import java.io.*;

class StaticBlockSingleton {
    private StaticBlockSingleton() throws IOException {
        System.out.println("Singleton is initializing");
        File.createTempFile(".", ".");
    }

    // if singleton object creating throws some error
    // then we have to use static block to prevent the runtime
    // error occurence
    // getInstance() method instance variable should be
    // initialized in static block

    private static StaticBlockSingleton instance;
    static {
        try {
            instance = new StaticBlockSingleton();
        }
        catch(Exception ex) {
            System.err.println("failed to create singleton");
        }
    }

    public static StaticBlockSingleton getInstance() {
        return instance;
    }

}

// Lazinness and Thread Safe Singleton
class LazySingleton {
    private static LazySingleton instance;
    private LazySingleton() {
        System.out.println("Initializing a lazy singleton");
    }
//    public static synchronized LazySingleton getInstance() {
//        if(instance == null) {
//            instance = new LazySingleton();
//        }
//        return instance;
//    }

    // double-checked locking
    public static LazySingleton getInstance() {
        if(instance == null) {
            synchronized (LazySingleton.class) {
                if(instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}

// Inner Static Singleton

class InnerStaticSingleton {
    private InnerStaticSingleton() {
        System.out.println("Initializing Inner Static Singleton");
    }

    // this things avoid the problem of synchronization

    private static class Imple {
        private static final InnerStaticSingleton INSTANCE = new InnerStaticSingleton();

    }
    public InnerStaticSingleton getInstance() {
        return Imple.INSTANCE;
    }
}


// Enum Based Singleton
// enums are also serializable by default
// an enum already has private default constructor
// and if we don't add any constructor here
// we are still not able to make new instances of enum
// anyway
// but we are still making the constructor
enum EnumBasedSingleton {
    INSTANCE;

    EnumBasedSingleton() {
        this.value = 42;
    }
    private int value;
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
}



public class Demo {
    static void saveToFile(EnumBasedSingleton singleton, String fileName) throws Exception {
        try (FileOutputStream fileOut = new FileOutputStream(fileName); ObjectOutputStream out = new ObjectOutputStream(fileOut)){
            out.writeObject(singleton);
        }
    }

    static EnumBasedSingleton readFromFile(String fileName) throws Exception {
        try(FileInputStream inFile = new FileInputStream(fileName); ObjectInputStream in = new ObjectInputStream(inFile)) {
            return (EnumBasedSingleton) in.readObject();
        }
    }
    public static void main(String[] args) throws Exception {
//        LazySingleton singleton = LazySingleton.getInstance();
//        System.out.println(LazySingleton.class);

        String fileName = "myFile.bin";
//        EnumBasedSingleton singleton = EnumBasedSingleton.INSTANCE;
//        singleton.setValue(111);
//        saveToFile(singleton, fileName);
        EnumBasedSingleton singleton2 = readFromFile(fileName);
//        singleton.setValue(390);
        System.out.println(singleton2.getValue());
//        System.out.println(singleton.getValue());

    }

}