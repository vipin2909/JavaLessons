package DesignPatterns.SingleResponsiblityPrinciple;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

class Journal {
    private final List<String> entries = new ArrayList<>();
    private static int count = 0;

    public void addEntry(String text) {
        entries.add("" + (++count) + ": " + text);
    }

    public void removeEntry(int index) {
        entries.remove(index);
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(), entries);
    }

    public void save(String fileName) throws FileNotFoundException {
        try(PrintStream out = new PrintStream(fileName)) {
            out.println(toString());
        }
    }

}

class Persistance {
    public void saveToFile(Journal journal, String fileName, boolean overWrite) throws FileNotFoundException {
        if (overWrite || new File(fileName).exists()) {
            try (PrintStream out = new PrintStream(fileName)) {
                out.println(journal.toString());
            }
        }
    }
}


public class Demo {
    public static void main(String[] args) throws Exception {
        Journal journal = new Journal();
        journal.addEntry("I cried today");
        journal.addEntry("I ate a bug");
        System.out.println(journal);

        Journal journal2 = new Journal();
        journal2.addEntry("I am Vipin");
        journal2.addEntry("I want to be a full stack developer");

        Persistance p = new Persistance();
        String fileName = "/home/appinventiv/IdeaProjects/JavaLessons/src/DesignPatterns/SingleResponsiblityPrinciple/journal.txt";
        p.saveToFile(journal, fileName, true);
        p.saveToFile(journal2, fileName, true);
        Runtime.getRuntime().exec("gedit " + fileName);
    }
}