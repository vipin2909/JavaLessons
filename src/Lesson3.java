public class Lesson3 {
    public static void main(String[] args) {
        int randomNumber = (int) (Math.random() * 30);
        /*
        Relational operator
        Java has 6 relation operator
        > : Greater than
        < : less than
        == : Equal to
        != : not equal to
        >= : Greater than equal to
        <= Less than equal to

         */

        if(randomNumber < 25) {
            System.out.println("The random number is less than 25");
        }
        else if(randomNumber > 40) {
            System.out.println("The random number is greater than 40");
        }
        // this condition is always false
        // if then condition is true than the above < 25 is also true
        // which make this statement impossible to reach
        // so this one is always result to false
        else if(randomNumber <= 18) {
            System.out.println("The random number is less than and equal to 18");
        }
        else if(randomNumber >= 40) {
            System.out.println("The random number is greater than and equal to 40");
        }

        /*

        Logical Operators
        Java has 6 logical operators
        !: Converts the boolean value to right to opposite
        &: Returns true if boolean value on and left are both true
        &&: Returns true if boolean value both are true and only check second value whren first is true
        |: Returns true if either boolean value is true
        ||: Returns true if either is true but stop checking for second if first is true
        ^: Returns true if one value is true and 1 value is false

         */
        if(!(false)) {
            System.out.println("\nI Turned false into true");
        }

        int valueOne = 1;
        int valueTwo = 2;
        int biggestValue = (valueOne > valueTwo) ? valueOne : valueTwo; // 2

        char theGrade = 'b';
        switch(theGrade) {
            case 'A':
                System.out.println("Great job !");
                break;
            case 'b':
            case 'B':
                System.out.println("Nice job");
                break;
            default:
                System.out.println("You failed !!");
        }
    }
}
