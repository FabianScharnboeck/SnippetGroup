import java.io.BufferedReader;
import java.io.InputStreamReader;


public class U_ForgoneSolution_Solution_a5858 {
	private static String trunc(String line) {
		for (int i=0; i<line.length(); i++) {
			if (line.charAt(i) != '0') {
				return line.substring(i);
			}
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int ts=1; ts<=T; ts++) {
			String line = in.readLine();
			int len = line.length();
			String num1 = "";
			String num2 = "";
			for (int i=0; i<len; i++) {
				if (line.charAt(i) == '4') {
					num1 = num1 + '1';
					num2 = num2 + '3';
				} else {
					num1 = num1 + line.charAt(i);
					num2 = num2 + '0';
				}
			}
			System.out.println("Case #" + ts + ": " + trunc(num1) + " " + trunc(num2));
		}
	}
}