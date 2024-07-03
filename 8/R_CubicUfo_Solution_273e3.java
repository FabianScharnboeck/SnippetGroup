package gcj2018.qualification.cubic_ufo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
public class Solution_273e3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            String A = in.next();
            double area = Double.parseDouble(A);
            double[][] res = getRes(area);
            System.out.println("Case #" + i + ": ");

            for (int j = 0; j < 3; j++) {
                System.out.println(res[j][0] + " " + res[j][1] + " " + res[j][2]);
            }
        }
    }

    public static double[][] getRes(double area) {
        double[][] res = new double[3][3];
        double theta = Math.PI/4 - Math.acos(area/Math.sqrt(2));
        res[2] = new double[]{0, 0, 0.5};
        res[0][0] = 0.5*Math.cos(theta);
        res[0][1] = -0.5*Math.sin(theta);
        res[0][2] = 0;

        res[1][0] = 0.5 * Math.sin(theta);
        res[1][1] = 0.5 * Math.cos(theta);
        res[1][2] = 0;

        return res;
    }
}