import javax.naming.NamingEnumeration;
import java.util.Arrays;
import java.util.LinkedList;

public class Lesson12 {
    public static void main(String[] args) {
        LinkedList linkedListOne = new LinkedList();
        LinkedList<String> names = new LinkedList<String>();

        names.add("Ahmed Bennani");
        names.add("Ali Syed");

        names.addLast("Nathan Martin");
        names.addFirst("Joshua Smith");
        names.add(0, "Noah Peters");
        names.set(2, "Paul Newman");
        names.remove(4);
        names.remove("Joshua Smith");

        System.out.println("\nFirst Index " + names.get(0));
        for(String name: names) {
            System.out.println(name);
        }

        System.out.println("\nLast Index " + names.getLast());
        LinkedList<String> nameCopy = new LinkedList<String>(names);
        System.out.println("\nnameCopy: " + nameCopy);

        if(names.contains("Noah Peters")) {
            System.out.println("Noah is here");
        }
        if(names.containsAll(nameCopy)) {
            System.out.println("Collections are same");
        }

        System.out.println("\nAli Index: " + names.indexOf("Ali Syed"));
        System.out.println("\nList Empty: " + names.isEmpty());
        System.out.println("\nHow Many: " + names.size());

        // if the list is empty
        // then get method returns an error but if we use
        // peek instead of get it will return null
        // if the list is empty and not throw an erorr
        System.out.println("\nLook Without Error: " + names.peek());

        System.out.println("\nRemove first element: " + nameCopy.poll());
        System.out.println("\nRemove last: " + nameCopy.pollLast());

        System.out.println(names);
        System.out.println(nameCopy);

        nameCopy.push("Noah Peters");
        // the pop function delete the first element
//        nameCopy.pop();
        for(String name: nameCopy) {
            System.out.println(name);
        }

        Object[] nameArray = new Object[4];
        nameArray = names.toArray();
        System.out.println(Arrays.toString(nameArray));
    }
}
