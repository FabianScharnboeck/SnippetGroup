import java.util.Scanner;

public class Solution_b44f3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        for (int i = 1; i <= t; i++) {

            int n = scanner.nextInt();

            int ansA;
            int ansB;

            if (String.valueOf(n).endsWith("4")) {
                ansA = n / 2;
                ansB = ansA;
            } else {
                ansA = 1;
                ansB = n - 1;

                boolean isFound = false;
                while (!isFound) {
                    if (String.valueOf(ansB).contains("4")) {

                        ansA++;
                        ansB--;
                    }

                    if (String.valueOf(ansA).contains("4")) {
                        ansA++;
                        ansB--;
                    }

                    if (!String.valueOf(ansB).contains("4") && !String.valueOf(ansA).contains("4")) {
                        isFound = true;
                    }
                }
            }


            System.out.println("Case #" + i + ": " + ansA + " " + ansB);
        }
    }
}
