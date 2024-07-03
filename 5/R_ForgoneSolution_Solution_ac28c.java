import java.util.Scanner;


public class R_ForgoneSolution_Solution_ac28c {

	static int digits(int n, boolean up){
		int k = 0;
		int res = n;
		while(n != 0){
			if(n%10==4){
				if(up)
					res += 10^k;
				else
					res -= 10^k;
			}
			k++;
			n=n/10;
		}
		return res;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
          //System.out.println(digits(n));
          int A = 1;
          int B = n - 1;
          while(A != digits(A,true) || B != digits(B,false)){
        	  A = digits(A,true);
        	  if(B == n-A){
        		  B = digits(B, false);
        		  A = n-B;
        	  }else
        		  B = n-A;
          }
          System.out.println("Case #" + i + ": " + A + " " + B);
        }
        in.close();
	}

}
