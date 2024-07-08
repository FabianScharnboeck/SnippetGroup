import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Pattern;

class U_YouCanGoYourOwnWay_Solution_b802d {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();

            if (n >= 2 && n <= 1000) {
                int LIMIT = (2 * n) - 2;
                String path = in.next(Pattern.compile("[ES]*"));
                if (path.length() > LIMIT) {
                    path = path.substring(0, LIMIT);
                }
                System.out.println("Case #" + i + ": " + pathSolution(path));
            }
        }
    }

    private static String pathSolution(String path) {
        String myPath = (path.charAt(0) == 'S') ? "E" : "S";
        for (int i = 1; i < path.length(); i++) {
            String subMyPath = myPath.concat((path.charAt(i) == 'S') ? "E" : "S");
            if (subMyPath.equals(path.substring(i - 1, i + 1))) {
                myPath = myPath.concat(String.valueOf(path.charAt(i)));
            } else {
                myPath = myPath.concat((path.charAt(i) == 'S') ? "E" : "S");
            }
        }
        return myPath;
    }
}