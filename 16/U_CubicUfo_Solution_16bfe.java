import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Locale;
import java.util.Scanner;


public class U_CubicUfo_Solution_16bfe {

	static boolean verb=true;
	static void log(Object X){if (verb) System.err.println(X);}
	static void log(Object[] X){if (verb) {for (Object U:X) System.err.print(U+" ");System.err.println("");}}
	static void log(int[] X){if (verb) {for (int U:X) System.err.print(U+" ");System.err.println("");}}
	static void logWln(Object X){if (verb) System.err.print(X);}
	static void info(Object o){	System.out.println(o);}
	static void output(Object o){outputWln(""+o+"\n");	}
	static void outputWln(Object o){try {out.write(""+ o);} catch (Exception e) {}}



	static String solve(double A){
		String ans="";
		return ans;
		
	}


	// Global vars

	static BufferedWriter out;
	
	static double[] rotate(double x,double y,double alpha){
		double u=x*Math.cos(alpha)-y*Math.sin(alpha);
		double v=y*Math.cos(alpha)+x*Math.sin(alpha);
		return new double[]{u,v};
		
	}


	static void process() throws Exception {
		
		out = new BufferedWriter(new OutputStreamWriter(System.out));
		Locale.setDefault(Locale.US);
		Scanner sc=new Scanner(System.in);





		int T=sc.nextInt();
		for (int t=1;t<=T;t++){

			double A=sc.nextDouble();
			

			String ss="\n";
			
			
			double alpha=Math.asin(A/Math.sqrt(2))-Math.PI/4;

			//double[] m1=rotate(1,0.5,alpha);
			//double[] m2=rotate(0.5,1,alpha);
			//double[] m3=rotate(0.5,0.5,alpha);
			
			double[] m1=rotate(0.5,0,alpha);
			double[] m2=rotate(0,0.5,alpha);
			double[] m3=rotate(0,0,alpha);
			
			
			ss+=m1[0]+" "+m1[1]+" "+0+"\n";
			ss+=m2[0]+" "+m2[1]+" "+0+"\n";
			ss+=m3[0]+" "+m3[1]+" "+0.5+"\n";
			
			
			//log("Case #"+t+": "+ss);
			output("Case #"+t+": "+ss);


		}

		try {
			out.close();
		}
		catch (Exception EX){}

	}








	public static void main(String[] args) throws Exception {
		process();

	}



}