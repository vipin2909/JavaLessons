import java.util.Scanner;

public class Lesson2 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Your Favorite number");
        if(sc.hasNextInt()) {
            int numberEntered = sc.nextInt();
            System.out.println("you entered " + numberEntered);
            int numAbs = Math.abs(numberEntered);
            int whichIsBigger = Math.max(5, 7);
            int whichIsSmaller = Math.min(5, 7);
            double numSqrt = (int) Math.sqrt(5.23);
            int numCelling = (int) Math.ceil(5.23);
            int numFloor = (int)Math.floor(5.23);
            int numRound = (int) Math.round(5.50);
            System.out.println("Number ceil is " + numCelling);
            System.out.println("number floor is " + numFloor);
            System.out.println("The round number is " + numRound );

            // Math.random() returns a number between 0 to 0.999999
            int randomNumber = (int)(Math.random() * 11);
            System.out.println("The random number is " + randomNumber );


        }
        else {
            System.out.println("Enter an integer next time");
        }
    }
}
