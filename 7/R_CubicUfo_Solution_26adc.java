package gcj2018.qualification.cubic_ufo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * @author Vladimir Kotov
 */
public class Solution_26adc {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= t; i++) {
            double a = Float.parseFloat(in.nextLine());
            String[][] r = process(a);
            System.out.println("Case #" + i + ": ");
            for (int j = 0; j < r.length; j++) {
                System.out.println(r[j][0] + " " + r[j][1] + " " + r[j][2]);
            }
        }
    }

    public static String[][] process(double a) {
        double x = 0, eps = 0;
        double f = fsin(x) - a;
        do {
            eps = -f / fcos(x);
            x += eps;
            f = fsin(x) - a;
        } while (eps > 0.0000000000001);

        return new String[][]{
                {p(Math.cos(x) / 2), p(Math.sin(x) / 2), "0.000000000000"},
                {p(Math.cos(x + Math.PI / 2) / 2), p(Math.sin(x + Math.PI / 2) / 2), "0.000000000000"},
                {"0.000000000000", "0.000000000000", "0.500000000000"},
        };
    }

    private static double fcos(double x) {
        return Math.sqrt(2) * Math.cos(x + Math.PI / 4);
    }

    private static double fsin(double x) {
        return Math.sqrt(2) * Math.sin(x + Math.PI / 4);
    }

    public static String p(double d) {
        return new BigDecimal(d).setScale(12, RoundingMode.FLOOR).toPlainString();
    }

}