import java.util.*;
import java.io.*;

public class U_TaskRobotProgrammingStrategy_Solution_136d06 {
    public static void main(String[] args) {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  
        for (int i = 1; i <= t; ++i) { 
        	int A = in.nextInt();
        	Set<String> competitors = new HashSet<>();


        	for (int j = 0; j < A; j++) {
        	    competitors.add(in.next());
            }

            StringBuilder sb = new StringBuilder();
        	boolean impossible = false;

        	int currentPosition = 0;
            while(currentPosition < 500) {
                Set<Character> curSet = collectCharSet(competitors, currentPosition);
                if (curSet.size() == 0) {break;}
                if (curSet.size() == 3) {impossible = true; break;}
                if (curSet.size() == 1) {
                    if (curSet.iterator().next() == 'P') {sb.append('S');break;}
                    if (curSet.iterator().next() == 'S') {sb.append('R');break;}
                    if (curSet.iterator().next() == 'R') {sb.append('P');break;}
                }
                if (curSet.size() == 2) {
                    if (curSet.contains('P') && curSet.contains('R')) {
                        sb.append('P');
                        updateCompetitors(competitors, 'R', currentPosition);
                        currentPosition++;
                    }

                    if (curSet.contains('P') && curSet.contains('S')) {
                        sb.append('S');
                        updateCompetitors(competitors, 'P', currentPosition);
                        currentPosition++;
                    }

                    if (curSet.contains('S') && curSet.contains('R')) {
                        sb.append('R');
                        updateCompetitors(competitors, 'S', currentPosition);
                        currentPosition++;
                    }
                }
            }
            String res;
            if (impossible) res = "IMPOSSIBLE";
            else res = sb.toString();


            System.out.println("Case #" + i + ": " + res);
        }
    }

    static void updateCompetitors(Set<String> competitors, char c, int i){
        Iterator iter = competitors.iterator();
        while (iter.hasNext()) {
            String str = (String) iter.next();
            if (str.charAt(i % str.length()) == c) iter.remove();
        }

    }

    static Set<Character> collectCharSet(Set<String> competitors, int i) {
        Set<Character> set = new HashSet<>();
        for (String s : competitors) {
            
            set.add(s.charAt(i % s.length()));
            
        }
        return set;
    }

    
}