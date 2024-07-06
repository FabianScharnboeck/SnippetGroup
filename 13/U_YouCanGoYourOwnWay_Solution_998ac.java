import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class U_YouCanGoYourOwnWay_Solution_998ac {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();// dimensions of the  maze
      // get rid of /n
      String a = in.nextLine();
      String p = in.nextLine();// string representing Lydia's path
      //we need we need 5 s's, 5 e's
      // algo confirms if each step at the same point
      // we go the opposite direction in  first thing
       // last is the last move
       int counter = 0;
       int lydSTotal = 0;
       int mySTotal = 0;
       String total = "";
       while(counter < 2*n-2){
           // gets the current value
           String curr = p.substring(counter,counter+1);
           // if the values of the counter for S are the same, do opposite
           // else do the same
           if(lydSTotal==mySTotal){
               if(curr.equals("S")){
                    
                    String add = "E";
                    lydSTotal++;
                     total = total + add;
                }else{
                    String add = "S";
                    mySTotal++;
                     total = total + add;
                }
           
           }else{
               total = total + curr;
               if(curr.equals("S")){
                   lydSTotal++;
                   mySTotal++;
               }
           }
           counter++;
       }
        

        
      System.out.println("Case #" + i + ": " + total);
    }
  }
}