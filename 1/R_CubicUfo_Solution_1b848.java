
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class R_CubicUfo_Solution_1b848 {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] ree = in.readLine().split("\\s++");
        int t = Integer.parseInt(ree[0]);
        int mmm = 0;
		double eps = 0.0000000001;
        while(mmm++ < t) {
			out.write("Case #" + mmm + ":\n");
			ree = in.readLine().split("\\s++");
			double req = Double.valueOf(ree[0]);
			if(req < 1.4142135) {
				double lo = 0.0;
				double hi = 0.3535533905932738;
				double mn = -1;
				double ex = -1;
				while((hi - lo) > eps) {
					mn = (hi + lo) / 2;
					ex = Math.sqrt(0.25 - mn * mn);
					if(2*(ex+mn) < req) lo = mn;
					else hi = mn;
				}
				out.write(ex + " " + mn + " 0\n");
				out.write(-mn + " " + ex + " 0\n");
				out.write("0 0 0.5\n");
			} else {
				out.write("0");
			}
        }
		out.flush();
    }
}