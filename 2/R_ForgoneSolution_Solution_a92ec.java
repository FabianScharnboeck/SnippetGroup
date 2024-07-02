import java.io.*;
import java.util.*;
class R_ForgoneSolution_Solution_a92ec
{
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(br.readLine());

        for(int i=1; i<=t; i++)
        {
            String str=br.readLine();
            String a="",b="",temp="";
            a=str.replace('4','3'); 
            b= str.replace('1',' ');
            b=b.replace('4','1');
            for(int j=0; j<10; j++)
            {
                if(j!=1 )
                {
                    String ch=""+j;
                    b= b.replace(ch.charAt(0),' ');
                }
            }
            b=b+'x';
            b=b.trim();
            b=b.replace(' ','0');
            b=b.replace('x',' ');
            b=b.trim();
            System.out.println("Case #"+i+": "+a+" "+b+" ");
        }
    }
}