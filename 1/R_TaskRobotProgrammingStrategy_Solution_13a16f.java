import java.util.*;

public class R_TaskRobotProgrammingStrategy_Solution_13a16f {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = Integer.parseInt(s.nextLine());
        int c = 0;
        while(c++<t) {
            int a = Integer.parseInt(s.nextLine());
            Set<String> set = new HashSet<>();
            for(int i = 0 ; i < a; ++i) {
                set.add(s.nextLine());
            }
            StringBuilder output = new StringBuilder();
            boolean possible = true;
            int nextPos = 0;
            while(!set.isEmpty()) {
                Map<Character,Set<String>> charsToString = new HashMap<>();
                for (String str : set) {
                    int l = str.length();
                    char ch = str.charAt(nextPos%l);
                    if(!charsToString.containsKey(ch)) {
                        charsToString.put(ch,new HashSet<>());
                    }
                    charsToString.get(ch).add(str);
                }
                if(charsToString.size()==3) {
                    possible = false;
                    break;
                }
                if(charsToString.size()==1) {
                    if(charsToString.containsKey('R'))
                        output.append('P');
                    else if(charsToString.containsKey('P'))
                        output.append('S');
                    else
                        output.append('R');
                    break;
                }
                if(charsToString.containsKey('R')) {
                    if(charsToString.containsKey('P')) {
                        output.append('P');
                        set = charsToString.get('P');
                    } else {
                        output.append('R');
                        set = charsToString.get('R');
                    }
                } else {
                    output.append('S');
                    set = charsToString.get('S');
                }
                nextPos++;
            }
            System.out.print("Case #" + c + ": ");
//            PRINTLN RESULT
            if(!possible) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(output.toString());
            }
        }
    }


}