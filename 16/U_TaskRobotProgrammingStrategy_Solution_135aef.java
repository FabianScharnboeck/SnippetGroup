import java.io.FileNotFoundException;
import java.util.Scanner;

public class U_TaskRobotProgrammingStrategy_Solution_135aef {

    static String solve(String[] array) {
        StringBuilder ans = new StringBuilder();
        boolean[] beat = new boolean[array.length];
        for (int i = 0; i < 500; i++) {
            boolean r = false;
            boolean s = false;
            boolean p = false;
            for (int j = 0; j < array.length; j++) {
                if (!beat[j]) {
                    char c = array[j].charAt(i % array[j].length());
                    switch (c) {
                        case 'R':
                            r = true;
                            break;
                        case 'S':
                            s = true;
                            break;
                        case 'P':
                            p = true;
                            break;
                    }
                }
            }
            if (r && s && p) {
                return "IMPOSSIBLE";
            }
            char chosen;
            if (r && s) {
                chosen = 'R';
            } else if (r && p) {
                chosen = 'P';
            } else if (s && p) {
                chosen = 'S';
            } else if (r) {
                chosen = 'P';
            } else if (p) {
                chosen = 'S';
            } else if (s) {
                chosen = 'R';
            } else {
                return ans.toString();
            }
            ans.append(chosen);
            for (int j = 0; j < array.length; j++) {
                if (!beat[j]) {
                    char c = array[j].charAt(i % array[j].length());
                    switch (c) {
                        case 'R':
                            if (chosen == 'P') {
                                beat[j] = true;
                            }
                            break;
                        case 'S':
                            if (chosen == 'R') {
                                beat[j] = true;
                            }
                            break;
                        case 'P':
                            if (chosen == 'S') {
                                beat[j] = true;
                            }
                            break;
                    }
                }
            }
        }
        return "IMPOSSIBLE";
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scanner = new Scanner(new File("resources/in"));
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 1; i <= T; i++) {
            int A = scanner.nextInt();
            String[] array = new String[A];
            for (int j = 0; j < A; j++) {
                array[j] = scanner.next();
            }
            System.out.println("Case #" + i + ": " + solve(array));
        }
    }
}