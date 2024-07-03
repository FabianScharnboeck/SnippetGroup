import java.util.*;
import java.io.*;
public class R_YouCanGoYourOwnWay_Solution_a849b {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            String str = in.next();
            String ans = "";
            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(j)=='E')
                {
                    ans = ans + 'S';
                }
                else
                {
                    ans = ans +'E';
                }
            }
            System.out.println("Case #" + i + ": " +ans);
        }
    }
}
