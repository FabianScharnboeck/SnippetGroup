import java.util.Scanner;

public class U_ForgoneSolution_Solution_aa533 {
    public static void main(String gg[]) {
        int firstNumber, secondNumber, number, testcases;
        Scanner scanner = new Scanner(System.in);
        testcases = scanner.nextInt();
        for (int j = 0; j < testcases; j++) {
            number = scanner.nextInt();
            firstNumber = number;
            secondNumber = 0;
            int length = String.valueOf(number).length();
            Integer intArray[] = new Integer[length];
            int place = 1;
            for (int i = 0; i < length; i++) {
                intArray[i] = number % 10;
                number = number / 10;
            }
            for (int i = 0; i < length; i++) {
                if (intArray[i] == 4) {
                    firstNumber = firstNumber - place;
                    secondNumber = secondNumber + place;
                }
                place = place * 10;
            }
            System.out.println("Case #" + (j + 1) + ": " + firstNumber + " " + secondNumber);
        }
    }
}