import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class U_SenateEvacuation_Solution_1c55
{
	public static void main(String[] args) throws FileNotFoundException
	{
	    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		String answer = "";

		int senatorCount, testCases = in.nextInt();
		int[] senators;

		
		for(int i = 0; i<testCases; i++)
		{
			senatorCount = in.nextInt();
			senators = new int[senatorCount];
			int x = 0;
			while(x < senatorCount)
			{
				senators[x] = in.nextInt();
				x++;
			}

			int firstSenatorPosition=0,secondSenatorPosition=0;
			int firstSenatorCount=0,secondSenatorCount=0;
			
			for(int z = 1; z < senatorCount ; z++)
			{
				if(senators[z] > firstSenatorCount)
				{
					secondSenatorPosition = firstSenatorPosition;
					secondSenatorCount = firstSenatorCount;
					firstSenatorPosition = z;
					firstSenatorCount = senators[z];
				}
				else if(senators[z] > secondSenatorCount)
				{
					secondSenatorPosition = z;
					secondSenatorCount = senators[z];
				}
			}

			//remove top 2 senator counts to be equal
			if(firstSenatorCount > secondSenatorPosition)
			{
				if(senators[firstSenatorPosition] > (senators[secondSenatorPosition] + 2))
				{
					answer += (char)(65+firstSenatorPosition) + "" + (char)(65+firstSenatorPosition) + " ";
					senators[firstSenatorPosition] -= 2;
				}
				else
				{
					answer += (char)(65+firstSenatorPosition) + " ";
					senators[firstSenatorPosition]--;
				}
			}
			
			//remove remaining non-top senators
			for(int a = 0; a< senatorCount; a++)
			{
				if(a != firstSenatorPosition && a != secondSenatorPosition)
				{
					while(senators[a] > 0)
					{
						if(senators[a] > 1)
						{
							answer += (char)(65+a) + "" + (char)(65+a) + " ";
							senators[a] -= 2;
						}
						else
						{
							answer += (char)(65+a) + " ";
							senators[a]--;
						}
					}
				}
			}
			
			//remove top 2 senators as last party equally
			while(senators[firstSenatorPosition] > 0)
			{
				answer += (char)(65+firstSenatorPosition) + "" + (char)(65+secondSenatorPosition) + " ";
				senators[firstSenatorPosition]--;
			}
			
			System.out.println("Case #" + (i+1) + ": " + answer + "\n");
			
		}
	}
}
