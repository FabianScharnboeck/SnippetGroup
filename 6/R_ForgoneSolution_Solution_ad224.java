import java.math.BigInteger;
import java.util.*;

class Solution_ad224 {

	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		String str = new String();
		int p,q,cs=1;
		while(t-- > 0)
		{
			str = s.next();
			char[] a = str.toCharArray();
			int len = a.length;
			char[] b = new char[len];
			for(int i=len-1;i>=0;i--)
			{
				p = Character.getNumericValue(a[i]);
				q =0;
				if(p!=0)
				{
					p -= 1;
					q = 1;
				}
				if(p == 4)
				{
					p-=1;
					q += 1;
				}
				a[i] = (char)(p+'0');
				b[i] = (char)(q+'0');
			}
			System.out.print("Case #"+cs+": ");
			cs++;
			for(int i=0;i<len;i++)
				System.out.print(a[i]);
			System.out.print(" ");
			for(int i=0;i<len;i++)
				System.out.print(b[i]);
			System.out.println();
		}
		

	}

}
