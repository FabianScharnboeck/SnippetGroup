package gcj2018.practise_session.senate_evacuation;

import java.util.Scanner;

/**
 *
 * @author win 7
 */
public class Solution_3cb0 {

    static int[] parties;
    static String[] p;
    static int sum;
    static String ans;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int t = 1; t <= test; t++) {
            ans = "Case #" + t + ":";
            int n = sc.nextInt();
            parties = new int[n];
            p = new String[n];
            sum = 0;
            for (int i = 0; i < n; i++) {
                int eyy = sc.nextInt();
                parties[i] = eyy;
                p[i] = alphabet.substring(i, i + 1);
                sum += eyy;
            }
            recurse();
            System.out.println(ans);
            
        }
    }
    public static boolean recurse() {
        for (int i = 0; i < parties.length; i++) {
            if (parties[i] != 0) {
                parties[i]--;
                sum--;
                for (int j = 0; j < parties.length; j++) {
                    if (parties[j] != 0) {
                        
                        parties[j]--;
                        
                        sum--;
                        boolean rip = false;
                        for (int k = 0; k < parties.length; k++) {
                            if (((double) parties[k]) / ((double) sum) > 0.5) {
                                rip = true;
                            }
                        }
                        if (!rip) {
                            if (recurse()) {
                                ans = ans + " " + p[i] + p[j];
                                return true;
                            } else {

                                parties[j]++;

                                sum++;
                            }
                        } else {

                            parties[j]++;

                            sum++;
                        }
                    }
                }
                boolean rip = false;
                for (int k = 0; k < parties.length; k++) {
                    if (((double) parties[k]) / ((double) sum) > 0.5) {
                        rip = true;
                    }
                }
                if (!rip) {
                    if (recurse()) {
                        ans = ans + " " + p[i];
                        return true;
                    } else {
                        parties[i]++;
                        sum++;
                    }
                } else {
                    parties[i]++;
                    sum++;
                }
                
            }
        }
        return sum == 0;
    }
    
    
}