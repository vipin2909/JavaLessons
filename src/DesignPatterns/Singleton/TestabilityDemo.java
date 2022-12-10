//package DesignPatterns.Singleton;
//
//
//import org.junit.Test;
//
//import java.io.File;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Dictionary;
//import java.util.Hashtable;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//
//class SingletonDatabase {
//    private Dictionary<String, Integer> capitals = new Hashtable<>();
//    private static int instanceCount = 0;
//    public static int getCount() {
//        return instanceCount;
//    }
//    private SingletonDatabase() {
//        instanceCount++;
//        System.out.println("Initialized Databse");
//        try {
//            File f = new File(SingletonDatabase.class.getProtectionDomain().getCodeSource().getLocation().getPath());
//            Path fullPath = Paths.get(f.getPath(), "capitals.txt");
//            List<String> lines = Files.readAllLines(fullPath);
//            System.out.println(lines);
//            for(int i = 0; i < lines.size(); i+=2) {
//                System.out.print(lines.get(i)+"\t"+lines.get(i+1));
//                capitals.put(lines.get(i).trim(), Integer.parseInt(lines.get(i+1)));
//            }
//        }
//        catch(Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static final SingletonDatabase INSTANCE = new SingletonDatabase();
//    public static SingletonDatabase getInstance() {
//        return INSTANCE;
//    }
//
//    public int getPopulation(String name) {
//        return capitals.get(name);
//    }
//}
//
//class SingletonRecordFinder {
//    public int getTotalPopulation(List<String> names) {
//        int result = 0;
//        for(String name: names) {
//            result += SingletonDatabase.getInstance().getPopulation(name);
//        }
//        return result;
//    }
//}
//public class TestabilityDemo {
//    @Test
//    public void singletonTotoalPopulationTest() {
//        SingletonRecordFinder rf = new SingletonRecordFinder();
//        List<String> names = List.of("Seoul", "Mexico City");
//        int tp = rf.getTotalPopulation(names);
//        assertEquals(17500000+17400000, tp);
//
//    }
//
//    public static void main(String[] args) {
//        System.out.println(SingletonDatabase.getInstance().capitals.get(0));
//        SingletonDatabase.getInstance();
//    }
//
//}
