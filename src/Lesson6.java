// java.lang.RunTimeException -> run time exception
// java.lang.Exception -> compile time exception code is not allowed to compile
// if any compile time exception is occurred

// ArithmeticException
// ClassNotFoundException
// IllegalArgumentException
// IndexOutOfBoundsException
// InputMismatchException

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Lesson6 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
//        System.out.println("How old are you?");
//        int age = checkValidAge();
//        if(age != 0) {
//            System.out.println("You are " + age);
//        }
//        divideByZero(2);

        try {


            getAFile("./somestuff.txt");
        }

        catch(IOException e) {
            System.out.println("AN IO ERROR OCCURED");
        }
    }

    public static void getAFile(String fileName) throws IOException, FileNotFoundException {
        FileInputStream file = new FileInputStream(fileName);
    }

    // always catch exception in specific order i.e most specific at top and
    // least specific after that
    // that is call exceptions based on their priority depending on try block
//    public static void getAFile(String fileName) {
//        try {
//            FileInputStream file = new FileInputStream(fileName);
//        }
//        catch(FileNotFoundException e) {
//            System.out.println("Sorry can't find that file");
//        }
//        catch(IOException e) {
//            System.out.println("Unknown IO Error");
//        }
//
//        catch(Exception e) {
//            System.out.println("Some error occured");
//        }
//
//        // we can ignore exception if we not need it
//        catch(ClassNotFoundException e) {
//
//        }
//
//        finally {
//            System.out.println("This executes in each and every condition no matter what");
//        }
//    }

    public static int checkValidAge() {
        try {
            return sc.nextInt();
        }
        catch(InputMismatchException e) {
                sc.next();
            System.out.println("That isn't a whole number");
            return 0;
        }
    }

    public static void divideByZero(int a) {
        try {
            System.out.println(a/0);
        }
        catch(ArithmeticException e) {
            System.out.println("You can't do that");
            System.out.println(e.getMessage());
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }
}
