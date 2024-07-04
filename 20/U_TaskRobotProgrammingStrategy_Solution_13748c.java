import java.io.PrintStream;
import java.util.*;

public class Solution_13748c {
    static final Map<String, String> COUNTER_MOVES = new HashMap<>();

    static {
        COUNTER_MOVES.put("S", "P");
        COUNTER_MOVES.put("P", "R");
        COUNTER_MOVES.put("R", "S");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        PrintStream out = System.out;

        int caseAmount = in.nextInt() + 1;
        for (int c = 1; c <  caseAmount; c++) {
            out.println("Case #" + c + ": " + solve(in));
        }
    }

    static String solve(Scanner scanner) {
        int k = scanner.nextInt();
        List<String> robotMoves = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            robotMoves.add(scanner.next());
        }

        String res = makeMove(robotMoves, Collections.emptySet(), "", 0);

        return res == null
                ?   "IMPOSSIBLE"
                :   res;
    }

    static String makeMove(List<String> robotMoves, Set<Integer> out, String moves, int move) {
        if (move > 500) {
            return null;
        }

        if (out.size() == robotMoves.size()) {
            return moves;
        }

        Set<String> possibleMoves = new HashSet<>();
        possibleMoves.add("S");
        possibleMoves.add("R");
        possibleMoves.add("P");

        for (int i = 0; i < robotMoves.size(); i++) {
            if (!out.contains(i)) {
                possibleMoves.remove(COUNTER_MOVES.get(getMove(move, robotMoves.get(i))));
            }
        }

        if (possibleMoves.isEmpty()) {
            return null;
        }

        for (String possibleMove: possibleMoves) {
            Set<Integer> newOut = new HashSet<>(out);
            for (int i = 0; i < robotMoves.size(); i++) {
                if (!out.contains(i)) {
                    if (!possibleMove.equals(getMove(move, robotMoves.get(i)))) {
                        newOut.add(i);
                    }
                }
            }
            String res = makeMove(robotMoves, newOut, moves + possibleMove, move + 1);
            if (res != null) {
                return res;
            }
        }
        return null;
    }

    static String getMove(int move, String moves) {
        return "" + moves.charAt(move % moves.length());
    }
}
