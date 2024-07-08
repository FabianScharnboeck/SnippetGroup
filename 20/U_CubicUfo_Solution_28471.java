import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class U_CubicUfo_Solution_28471
{
	public static void main(String[] args)
	{
		try
		{
			start();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private static void start() throws NumberFormatException, IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int testCases = Integer.parseInt(reader.readLine());
		
		for (int i = 0; i < testCases; ++i)
		{
			String[] arr = reader.readLine().split(" ");
			double val = Double.parseDouble(arr[0]);
			
			System.out.println("Case #" + (i+1) + ":");

			doTestCase(val);
		}
	}
	
	private static void doTestCase(double val) throws IOException
	{
		double omega = Math.acos((val / 2.0) / (Math.sqrt(2.0) / 2.0));
		
		double x1 = Math.cos(omega + (Math.PI / 4)) * 0.5;
		double y1 = Math.sin(omega + (Math.PI / 4)) * 0.5;
		double x2 = Math.cos(omega - (Math.PI / 4)) * 0.5;
		double y2 = Math.sin(omega - (Math.PI / 4)) * 0.5;
		
		System.out.println("" + x1 + " " + y1 + " 0");
		System.out.println("" + x2 + " " + y2 + " 0");
		System.out.println("0 0 0.5");
	}
}