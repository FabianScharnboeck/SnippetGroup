import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Scanner;


public class U_CubicUfo_Solution_14ff4 {
	
	public static void main(String[] args) {
		solve();
		
		//solve(1);
		//solve(1.22474438436220233195566523648);
		//solve(1.414213);
		
	}

	private static void solve() {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    sc.useLocale(Locale.ENGLISH);
		

		long t = sc.nextLong();
		sc.nextLine();
		
		//System.out.println(t);
		for (long i = 0; i < t; i++) {
			double s = sc.nextDouble();
			System.out.println("Case #" + (i+1) + ":");
			solve(s);
		}
		sc.close();
	}

	private static void solve(double s) {

		double c1[] = {0.5, 0, 0};
		double c2[] = {0.5, 0, 0};
		double c3[] = {0.5, 0, 0};
		
		// rotate
		// check for area
		// print
		double max = Math.sqrt(2);

		
		// simple case, just rotate along one axis
		double cos = s/max;
		double sin = Math.sqrt(1-cos*cos); 
				
		double alfa = Math.toDegrees(Math.acos(cos));
		
		
		
		double x = 0.5*Math.cos(Math.toRadians(45-alfa));
		double y = 0.5*Math.sin(Math.toRadians(45-alfa));
		double z = 0;
		/*
		System.out.println("angle: " + alfa);
		System.out.println("area:" + s);
		System.out.println("cos(a)=" + cos);
		System.out.println("sin(a)=" + sin);
		*/
		
		System.out.println(x + " " + y + " 0");
		System.out.println(-y + " " + x + " 0");
		System.out.println("0 0 0.5");
		
		// TODO Auto-generated method stub
		
	}






}
