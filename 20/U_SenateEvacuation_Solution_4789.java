import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

class U_SenateEvacuation_Solution_4789 {

   public static void main(String[] args) throws Exception {
//
//		File file = Paths.get("input.txt").toFile();
//		if (file.exists()) {
//			System.setIn(new FileInputStream(file));
//		}

       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       int t = Integer.valueOf(reader.readLine());

       class Pair {
           int num;
           char c;

           public Pair(int num, char c) {
               this.num = num;
               this.c = c;
           }
       }
       int tid = 1;
       String output = "";
       while (t-- > 0) {

           int n = Integer.valueOf(reader.readLine());
           int[] s = Arrays.stream(reader.readLine().split(" ")).mapToInt(v -> Integer.valueOf(v)).toArray();

           PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> -Integer.compare(p1.num, p2.num));

           int num=0;
           char c = 'A';
           for (int ss : s) {
               num+=ss;
               pq.add(new Pair(ss, c++));
           }

           while (pq.size() > 0) {

               Pair p1 = pq.poll();
               Pair p2 = pq.poll();

               if (p1.num == p2.num) {

                   if (num > 3||num==2) {
                       p1.num -= 1;
                       p2.num -= 1;
                       num -= 2;
                       output += " " + p1.c + p2.c;

                   } else if (num == 3) {
                       p1.num -= 1;
                       num -= 1;
                       output += " " + p1.c;
                   }
               } else if (p1.num > p2.num + 1) {
                   p1.num -= 2;
                   num -= 2;
                   output += " " + p1.c + p1.c;
               } else {
                   p1.num -= 1;
                   num-= 1;
                   output += " " + p1.c;
               }
               if (p1.num > 0) {
                   pq.add(p1);
               }
               if (p2.num > 0) {
                   pq.add(p2);
               }

           }
           System.out.println("Case #" + tid + ": " + output.trim());
           output = "";
           tid++;
       }

   }

}
