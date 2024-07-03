import java.util.Scanner;

public class Solution_ae65b  {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int l = 0;
        while(l < t){
            int i = sc.nextInt();
            int n = i;
            int s = 0;
            int k = 1;
            while(n > 0){
                int p = n%10;
                n = n/10;
                if(p == 4){
                    i = i - (k*1);
                    s = s + (k * (1));
                }
                k = k * 10;
            }
            l++;
            System.out.println("Case #" +l +": " + i + " " + s);
        }

    }



}
