import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class U_ForgoneSolution_Solution_bdb9c {
    public static void main(String[] args) {
Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        int T=sc.nextInt();
        
        int duplicate1,duplicate2;
        
        for (int i = 1; i <= T; i++) {
           int N,part1,part2;
            N=sc.nextInt();
            duplicate1=N/2;
            N=N-duplicate1;
            part1=duplicate1;
            part2=N;
            while(i<=T){
           int count1=0,count2=0;
                while(part1!=0||part2!=0)
            {
                int rem=part1%10;
                part1=part1/10;
            
                int rem2=part2%10;
                part2=part2/10;
                
                if(rem==4)
                { 
                    count1++;
                    break;
                   }
                if(rem2==4)
                { 
                    count2++;
                    break;
                   }
            
              }
            
            if(count1!=0||count2!=0)
            {duplicate1++;
            N--;
           
                part1=duplicate1;
            part2=N;
                }
            else
            {break;}
        }
            System.out.println("Case #"+i+": "+duplicate1+"  "+N);
        }
    
    }
    
}
