import java.util.Arrays;

public class Lesson13 {
    public static void main(String[] args) {
        String randomString = "I'm just a random String";
        String goToQuote = "He said, \"I'm here\"";
        System.out.println(randomString + " " + goToQuote);
        int numTwo = 2;
        System.out.println(randomString + " " + numTwo);

        String upperCase = "BIG";
        String lowerCase = "big";
        if(upperCase.equalsIgnoreCase(lowerCase)) {
            System.out.println("They are equal");
        }

        String letters = "abcde";
        String moreLetters = "fghijk";
        System.out.println("2nd char " + letters.charAt(1));

//        System.out.println(letters.compareTo(moreLetters));
//
//        System.out.println(letters.contains("abc"));
//        System.out.println(letters.endsWith("de"));
//        System.out.println(letters.indexOf("cd"));

        // You can speciy the index to start searching from
        // indexOf(StringToLookFor, IndexStartPosition);


        // lastIndexOf() works like indexOf except it starts from the last
        // end of the String you are searching

//        System.out.println(letters.lastIndexOf("cd"));
//        System.out.println(letters.indexOf("cd", 2));
//
//
//        System.out.println("Length: " + letters.length());
        System.out.println(letters.replace("abc", "xy"));

        String[] letterArray = letters.split("");
        System.out.println(Arrays.toString(letterArray));

        char[] charArray = letters.toCharArray();
        System.out.println(Arrays.toString(charArray));

        System.out.println(letters.substring(1, 4));

        String randString = "             abfgfhfj      ";
        System.out.println(randString.trim());

        // String is immutable means every time you change a string
        // in any way it doesn't delete the previous version in memory
        // what it does it creates a brand new location for String over and over again

        // this is time consuming
        // to overcome this we can use StringBuilder

        StringBuilder randSB = new StringBuilder("A random value");
        System.out.println(randSB.append(" again"));
        System.out.println(randSB);
        System.out.println(randSB.delete(15, 21));

        System.out.println(randSB.capacity());
        randSB.ensureCapacity(60);
        System.out.println(randSB.capacity());
        System.out.println(randSB.length());

        randSB.trimToSize();
        System.out.println(randSB.capacity());
        System.out.println(randSB.insert(1, "nother"));
        String oldSB = randSB.toString();

        // same methods as String
        // charAt(), indexOf(), lastIndexOf(), substring(),


    }
}
