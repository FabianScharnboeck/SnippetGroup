import java.util.PriorityQueue;
import java.util.Scanner;

public class U_SenateEvacuation_Solution_548f {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int i=1; i<=t; i++){
			int n = sc.nextInt();
			
			PriorityQueue<Party> p = new PriorityQueue<>();

			for(int j=0; j<n; j++){
				int members = sc.nextInt();
				p.add(new Party((char)('A' + j), members));
			}
			
			System.out.print("Case #" + i + ": ");
			
			while(p.peek().members > 1){
				Party max = p.poll();
				Party next = p.poll();				
				
				if(max.members != next.members){
					if(max.members == 2){
						System.out.print(max.name);
						max.members = max.members - 1;
					}else{
						System.out.print(max.name);
						System.out.print(max.name);
						max.members = max.members - 2;
					}
				}else{
					System.out.print(max.name);
					System.out.print(next.name);
					max.members = max.members - 1;
					next.members = next.members - 1;
				}
								
				p.add(max);			
				p.add(next);				
				System.out.print(" ");
			}
			
			if(p.size() % 2 != 0){
				System.out.print(p.poll().name);
			}
			
			while(!p.isEmpty()){
				Party x = p.poll();
				Party y = p.poll();
				System.out.print(" ");
				System.out.print(x.name);
				System.out.print(y.name);
			}
			
			System.out.println();
		}

	}

}

class Party implements Comparable<Party> {
	public char name;
	public int members;	
	
	public Party(char name, int members) {		
		this.name = name;
		this.members = members;
	}

	@Override
	public int compareTo(Party o) {
		return o.members - this.members;
	}	
}
