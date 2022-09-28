import java.util.Arrays;

public class Lesson9 {
    public static void main(String[] args) {
        int[] randomArray;
        int[] numberArray = new int[10];
        randomArray = new int[20];
        randomArray[1] = 2;
        String[] stringArray = {"just", "random", "words"};
        for(int i = 0; i < numberArray.length; i++) {
            numberArray[i] = i;
        }
        int k = 1;
        while(k <= 41) {
            System.out.print("-");
            k++;
        }
        System.out.println();
        for(int j = 0; j < numberArray.length; j++) {
            System.out.print("| " + j + " ");
        }
        System.out.println("|");

        String[][] multiArray = new String[10][10];
        for(int i = 0; i < multiArray.length; i++) {
            for(int j = 0; j < multiArray[i].length; j++) {
                multiArray[i][j] = i + " " + j;
            }
        }

        System.out.println("\n\n");
        k = 1;
        while(k <= 61) {
            System.out.print("-");
            k++;
        }
        System.out.println();
        for(int i = 0; i < multiArray.length; i++) {
            for(int j = 0; j < multiArray[i].length; j++) {
                System.out.print("| " + multiArray[i][j] + " ");
            }
            System.out.println("|");
        }
        k = 1;
        while(k <= 61) {
            System.out.print("-");
            k++;
        }
        System.out.println("\n\n\n");

        for(String[] rows: multiArray) {
            for(String column: rows) {
                System.out.print("| "+ column + " ");
            }
            System.out.println("|");
        }

        int[] numberCopy = Arrays.copyOf(numberArray, 5);

        for(int element: numberCopy) {
            System.out.print(element);
        }
        System.out.println("\n");
        numberCopy[0] = 100;
        for(int element: numberCopy) {
            System.out.print(element);
        }
        System.out.println("\n");
        for(int element: numberArray) {
            System.out.print(element);
        }
        System.out.println("\n");

        // Arrays.copyOfRange(numberArray, startIndex, endIndex);
        // note: startIndex >= 0 && startIndex <= endIndex && endIndex < numberArray.length

        System.out.println(Arrays.toString(numberCopy));

        int[] moreNumbers = new int[100];
        Arrays.fill(moreNumbers, 2);

        char[][] boardGame = new char[10][10];
        for(char[] row: boardGame) {
            Arrays.fill(row, '*');
        }

        int[] numToSort = new int[10];
        for(int i = 0; i < 10; i++) {
            numToSort[i] = (int) (Math.random() * 100);
        }
        Arrays.sort(numToSort);
        System.out.println(Arrays.toString(numToSort));

        int whereIs50 = Arrays.binarySearch(numToSort, 50);
        System.out.println("The value of 50 is at index " + whereIs50);
    }
}
