import java.util.Scanner;

public class Lesson5 {
    static double myPi = 3.14159; // Class Variable
    static int randomNumber;

    public static void main(String[] args) {
        System.out.println(addThem(1, 2));
        System.out.println(myPi);

        Scanner sc = new Scanner(System.in);

        int d = 5;
        tryToChange(d);
        System.out.println("Main d = " + d);

        System.out.println(getRandomNumber());
        int guessResult = 1;
        int randomGuess = 0;
        while(guessResult != -1) {
            System.out.println("Guess a number between 0 and 50: ");
            randomGuess = sc.nextInt();
            guessResult = checkGuess(randomGuess);
        }
        System.out.println("Yes the random number is " + randomGuess);
    }

    public static int checkGuess(int guess) {
        if(guess == randomNumber) {
            return -1;
        }
        else {
            return guess;
        }
    }

    public static int getRandomNumber() {
        randomNumber = (int) (Math.random() * 51);
        return randomNumber;
    }
    public static void tryToChange(int d) {
        d = d + 1;
        System.out.println("try to change d = " + d);
    }

    public static int addThem(int a, int b) {
        double smallPi = 3.140; // Local Variable
        double myPi = 3.0;
        System.out.println("Global " + myPi);
        int c = a + b;
        return c;
    }
}
