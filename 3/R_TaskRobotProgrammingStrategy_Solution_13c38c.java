import java.util.*;
public class R_TaskRobotProgrammingStrategy_Solution_13c38c{
    private static final Scanner scanner = new Scanner(System.in);
    public static boolean[] disAllow(boolean allow[],ArrayList<Integer> al){
        int sz=al.size();
        for(int i = 0;i<sz;i++){
            allow[al.get(i)] = false;
            //System.out.print("  "+ i +allow[i]);
            //System.out.println();
        }
        return allow;
    }
    public static void main(String[] args){
        int T = Integer.parseInt(scanner.nextLine());
        for(int tZ = 0;tZ<T;tZ++){
            int n = Integer.parseInt(scanner.nextLine());
            
            String [] ar = new String[n];
            int ind[] = new int[n];
            int arL[] = new int[n];
            int  max = -1;
            boolean allow[] = new boolean[n];
            for(int i=0;i<n;i++){
                ar[i] = scanner.nextLine();
                ind[i] = 0;
                arL[i] = ar[i].length();
                if(max<arL[i])
                    max = arL[i];
                allow[i] = true;
            }
            boolean flag = true;
            StringBuffer oSb = new StringBuffer("");
            boolean output = false;
            int count = 0;
            max = max*2;
            while(flag){
                HashMap<Character,ArrayList<Integer>> st= new HashMap<Character,ArrayList<Integer>>();
                for(int i=0;i<n;i++){
                    if(allow[i]){
                        char c = ar[i].charAt(ind[i]);
                        ArrayList<Integer> al ;
                        if(st.containsKey(c)){
                            al = st.get(c);
                        }else{
                            al = new ArrayList<Integer>();
                        }
                        al.add(i);
                        st.put(c,al);
                        ind[i] = (ind[i] + 1) % arL[i];
                    }
                }
                //System.out.println(st);
                int stS = st.size();
                if(stS==3){
                    flag = false;
                }else if(stS==2){
                    if(st.containsKey('P') && st.containsKey('R')){
                        oSb.append("P");
                        allow = disAllow(allow,st.get('R'));
                    }else if(st.containsKey('R') && st.containsKey('S')){
                        oSb.append("R");
                        allow = disAllow(allow,st.get('S'));
                    }else if(st.containsKey('S') && st.containsKey('P')){
                        oSb.append("S");
                        allow = disAllow(allow,st.get('P'));
                    }
                }else if (stS==1){
                    flag = false;
                    output = true;
                    if(st.containsKey('P')){
                        oSb.append("S");
                    }else if(st.containsKey('R')){
                        oSb.append("P");
                    }else if(st.containsKey('S')){
                        oSb.append("R");
                    }
                }
                count++;
                if(count>max)
                    flag = false;
            }
            if(output)
                System.out.println("Case #"+(tZ + 1)+": " + oSb.toString());
            else
                System.out.println("Case #"+(tZ + 1)+": IMPOSSIBLE");
        }
    
    }
}
