import java.sql.Array;
import java.util.Iterator;
import java.util.Arrays;
import java.util.ArrayList;

public class Lesson11 {
    public static void main(String[] args) {
        ArrayList arrayListOne;
        arrayListOne = new ArrayList();

        ArrayList arrayListTwo = new ArrayList();

        ArrayList<String> names = new ArrayList<String>();
        names.add("John Smith");
        names.add("Mohamed Alami");
        names.add("Oliver Miller");

        names.add(2, "Jack Ryan");
        names.set(0, "John Adams");
//        names.remove(3);
        // this is protected method will check it later

//        names.removeRange(0, 2);
         for(int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }

        System.out.println(names);
         for(String i: names) {
             System.out.println(i);
         }

         Iterator indivItems = names.iterator();
         while(indivItems.hasNext()) {
             System.out.println(indivItems.next());
         }

         ArrayList nameCopy = new ArrayList();
         ArrayList nameBackup = new ArrayList();
         nameCopy.addAll(names);
         String paulYoung = "Paul Young";
         names.add(paulYoung);

         if(names.contains(paulYoung)) {
             System.out.println("Paul is here");
         }

         if(names.containsAll(nameCopy)) {
             System.out.println("Everything in nameCopy is in names");
         }

         // Copied names to nameCopy
        // Added to names

        if(nameCopy.containsAll(names)) {
            System.out.println("Everything in names is in nameCopy");
        }
        names.clear();
        if(names.isEmpty()) {
            System.out.println("Array list is Empty");
        }

        Object[] moreNames = new Object[4];
        moreNames = nameCopy.toArray();

        System.out.println(Arrays.toString(moreNames));

    }
}
