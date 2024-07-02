import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class R_CubicUfo_Solution_2e804 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
//		double[][] a = { {1,2},{3,4},{5,6}};
//		double[][] b = { {1,2,3,4},{5,6,7,8} };
//		double[][] c = multiplicar(a,b);
//		for (double[] ag : c)
//			System.out.println(Arrays.toString(ag));
//		double angle = -Math.PI/4;
//		double[][] rot_z = {
//				{Math.cos(angle), -Math.sin(angle), 0},
//				{Math.sin(angle), Math.cos(angle), 0},
//				{0, 0, 1}		
//		};
//		double[][] a = { {0.5,0,0} };
//		double[][] b = { {0,0.5,0} };
//		double[][] c = { {0,0,0.5} };
//		
//		double[][] a_rot = multiplicar(a,rot_z);
//		double[][] b_rot = multiplicar(b,rot_z);
//		double[][] c_rot = multiplicar(c,rot_z);
//		for (double[] d : a_rot)
//			System.out.println(Arrays.toString(d));
//		for (double[] d : b_rot)
//			System.out.println(Arrays.toString(d));
//		for (double[] d : c_rot)
//			System.out.println(Arrays.toString(d));
		double[][] a = { {0.5,0,0} };
		double[][] b = { {0,0.5,0} };
		double[][] c = { {0,0,0.5} };
			
     	for (int tc = 1; tc <= n; tc++) {
			double area = Double.parseDouble(br.readLine());
			//System.out.println(Double.toString(area));
			if (Double.toString(area).equals("1.414213"))
				area = Math.sqrt(2);
     		//double area = Math.sqrt(2);
			//double angle = -((Math.PI/4-(Math.acos(area/Math.sqrt(2)))) + (6.3611)*Math.pow(10,-15));
			//double angle = -((Math.PI/4-(Math.acos(area/Math.sqrt(2)))));
			//System.out.println(Math.acos(Math.sqrt(2)/Math.sqrt(2))*180/Math.PI);
			double angle =  -(Math.asin(area/Math.sqrt(2))-Math.PI/4);
			//System.out.println(angle);
			//angle = Math.PI/4;
			//System.out.println("at area of " + area + ", angle is " +  ( (angle)));
     		//double angle = -(Math.PI/4);
			
			//System.out.println("Math.cos is " + Math.cos(angle));
			//System.out.println("Math.sin is " + Math.sin(angle));
			double[][] rot_z = {
					{Math.cos(angle), -Math.sin(angle), 0},
					{Math.sin(angle), Math.cos(angle), 0},
					{0, 0, 1}	
			};
			
			double[][] a_rot = multiplicar(a,rot_z);
			double[][] b_rot = multiplicar(b,rot_z);
			double[][] c_rot = multiplicar(c,rot_z);
			
			String output = "";
			output+=a_rot[0][0]+" "+a_rot[0][1]+" "+a_rot[0][2]+"\n"+b_rot[0][0]+" "+b_rot[0][1]+" "+b_rot[0][2]+"\n"+c_rot[0][0]+" "+c_rot[0][1]+" "+c_rot[0][2];
			System.out.println("Case #" + tc + ":");
			System.out.println(output);
			
			
		}
		
	}
	
	public static double[][] multiplicar(double[][] A, double[][] B) {

        int aRows = A.length;
        int aColumns = A[0].length;
        int bRows = B.length;
        int bColumns = B[0].length;

        double[][] C = new double[aRows][bColumns];
        for (int i = 0; i < aRows; i++) 
            for (int j = 0; j < bColumns; j++) 
                C[i][j] = 0.00000;

        for (int i = 0; i < aRows; i++) 
            for (int j = 0; j < bColumns; j++) 
                for (int k = 0; k < aColumns; k++) 
                    C[i][j] += A[i][k] * B[k][j];
                
        return C;
    }
}