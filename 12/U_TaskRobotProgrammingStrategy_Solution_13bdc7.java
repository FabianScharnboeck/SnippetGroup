import java.util.*;
import java.io.*;
import java.util.stream.IntStream;

public class Solution_13bdc7 {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();

        for(int i = 0; i < t; ++i) {
            int robots = in.nextInt();
            //String[] ins = new String[robots];
            List<String> ins = new ArrayList<>();
            for (int j = 0; j < robots; ++j) {
                ins.add(in.next());
            }

            StringBuilder myi = new StringBuilder();
            boolean isImposible = false;
            for (int j = 0; j < 500; j++){
                boolean[] seen = new boolean[3];
                for (int k = 0; k < ins.size(); k++) {
                    switch(ins.get(k).charAt(j % ins.get(k).length())) {
                        case 'R':
                            seen[0] = true;
                            break;
                        case 'P':
                            seen[1] = true;
                            break;
                        default:
                            seen[2] = true;
                    }
                }

                if (seen[0] && seen[1] && seen[2]){
                    isImposible = true;
                    break;
                }
                else if (seen[0] && seen[1]) {
                    myi.append('P');
                    remove(ins, 'R', j);
                }
                else if (seen[0] && seen[2]) {
                    myi.append('R');
                    remove(ins, 'S', j);
                }
                else if (seen[1] && seen[2]) {
                    myi.append('S');
                    remove(ins, 'P', j);
                }
                else if (seen[0]) {
                    myi.append('P');
                    break;
                }
                else if (seen[1]) {
                    myi.append('S');
                    break;
                }
                else if (seen[2]) {
                    myi.append('R');
                    break;
                }

//                for (int k = 0; k < ins.size(); k++) {
//                    System.out.println(ins.get(k));
//                }
//                System.out.println();
            }
            if (isImposible) {
                System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
            }
            else {
                System.out.println("Case #" + (i + 1) + ": " + myi);
            }

        }

    }

    public static void remove( List<String> ins, char b, int index){
        for (int k = 0; k < ins.size(); k++) {
            if (ins.get(k).charAt(index % ins.get(k).length()) == b) {
                //System.out.println(ins.get(k));
                ins.remove(k);
                k--;
            }
        }
    }
}
