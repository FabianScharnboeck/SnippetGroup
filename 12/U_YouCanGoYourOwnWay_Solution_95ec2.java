    import java.util.*;
    import java.io.*;
    import java.lang.StringBuilder;
    
    public class U_YouCanGoYourOwnWay_Solution_95ec2 {
      public static void main(String[] args) {
          
        Scanner in = 
        new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        
        for (int i = 1; i <= t; ++i) 
        {
            int n = in.nextInt();
            String p = in.next();
            
            StringBuilder r = new StringBuilder("");
            
            for(int j = 0; j < p.length(); j++)
            {
            	if(p.charAt(j) == 'S')
            	{
            		r.append('E');
            	}
            	else
            	{
            		r.append('S');
            	}
            }
            System.out.println("Case #" + Integer.toString(i) + ": " + r.toString());
            
        }
        in.close();
      }
   }