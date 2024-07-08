import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class U_SenateEvacuation_Solution_72a7 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt(); //number of test cases
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> totals = new ArrayList<>();
        for(int i = 1; i <= t; i++) {
            int n = sc.nextInt(); //number of parties
            List<Integer> counts = new ArrayList<>();
            int total = 0;
            for(int j = 0; j < n; j++) {
                counts.add(sc.nextInt()); //politician count P_i
                total += counts.get(j);
            }
            totals.add(total);
            list.add(counts);
        }
        for(int i = 0; i < list.size(); i++) {
            int total = totals.get(i);
            String result = "Case #" + (i+1) + ": ";
            int n = list.get(i).size();
            for(int j = 0; j < n; j++) {
                while(total > 0) {
                    int max = 0;
                    int second = -1;
                    for(int k = 1; k < n; k++) {
                        max = (list.get(i).get(max) >= list.get(i).get(k)) ? max : k;
                    }
                    //search for second max-value if it exists
                    for(int k = 0; k < n; k++) {
                        if(k != max && list.get(i).get(max).equals(list.get(i).get(k))) {
                            second = k;
                            break;
                        }
                    }
                    //get ASCII value of capital alphabetical character for max
                    char a = (char) (max + 65);
                    if(second != -1 && total != 3) {
                        //get ASCII value of capital alphabetical character for max and second
                        char b = (char) (second + 65);
                        total -= 2;
                        list.get(i).set(max, list.get(i).get(max)-1);
                        list.get(i).set(second, list.get(i).get(second)-1);
                        result += String.valueOf(a) + String.valueOf(b) + ((total > 0) ? " " : "");
                    } else {
                        if(list.get(i).get(max) == 1) {
                            list.get(i).set(max, list.get(i).get(max)-1);
                            result += String.valueOf(a) + ((--total > 0) ? " " : "");
                        } else {
                            total -= 2;
                            list.get(i).set(max, list.get(i).get(max)-2);
                            result += String.valueOf(a) + String.valueOf(a) + ((total > 0) ? " " : "");
                        }
                    }
                }
            }
            System.out.println(result);
        }
    }
}