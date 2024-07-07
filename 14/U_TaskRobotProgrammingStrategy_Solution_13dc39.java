import java.util.*; 

class U_TaskRobotProgrammingStrategy_Solution_13dc39 {

    public static boolean beats(char pl, char ch) {
        return (ch == 'R' && pl == 'P') || (ch == 'P' && pl == 'S') || (ch == 'S' && pl == 'R');
    }

    public static String computeSol(String[] progs, int maxLen, int a) {
        boolean[] beaten = new boolean[a];
        Arrays.fill(beaten, false);
        StringBuilder sol = new StringBuilder();

        for (int i = 0; i < maxLen + 1; i++) {
            Set<Character> vals = new HashSet<Character>();

            for (int j = 0; j < a; j++) {
                // For each adv
                if (beaten[j])
                    continue;
                
                char ch = progs[j].charAt(i % progs[j].length());
                vals.add(ch);
            }

            char choice = 'X';
            Character[] arr = new Character[vals.size()];
            arr = vals.toArray(arr);
            if (vals.size() == 3)
                return "IMPOSSIBLE";
            else if (vals.size() == 2) {
                if (beats(arr[0], arr[1]))
                    choice = arr[0];
                else
                    choice = arr[1];  
            } else if (vals.size() == 1) {
                if (arr[0] == 'R')
                    choice = 'P';
                else if (arr[0] == 'P')
                    choice = 'S';
                else
                    choice = 'R';
            }

            boolean won = true;
            for (int j = 0; j < a; j++) {
                if (beaten[j])
                    continue;
                // For each adversary
                char ch = progs[j].charAt(i % progs[j].length());
                char pl = choice;
                boolean wonBool = (ch == 'R' && pl == 'P') || (ch == 'P' && pl == 'S') || (ch == 'S' && pl == 'R');
                if (wonBool)
                    beaten[j] = wonBool;
                won = won && wonBool;
            }

            if (won) {
                sol.append(choice);
                return sol.toString();
            }

            sol.append(choice);
        }
        return sol.toString();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int c = 0; c < t; c++) {
            // Take input
            int a = sc.nextInt();
            int maxLen = 0;
            String[] progs = new String[a];
            for (int i = 0; i < a; i++) {
                progs[i] = new String(sc.next());
                if (maxLen < progs[i].length())
                    maxLen = progs[i].length();
            }

            String soln = computeSol(progs, maxLen, a);
            System.out.println("Case #" + (c + 1) + ": " + soln);
        }
    }
}