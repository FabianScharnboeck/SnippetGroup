import java.util.Comparator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class U_SenateEvacuation_Solution_75d4{
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        
        for(int i = 0; i<testCases; i++){
            System.out.print("Case #" + (i+1) + ": ");
            int charNumber = 65; //A
            SortedSet<Party> parties = new TreeSet<Party>(new Comparator<Party>() {
		        @Override
		        public int compare(Party o1, Party o2) {
			        return Integer.compare(o1.count, o2.count);
		        }
	        });
            int partiesCount = sc.nextInt();
            for(int j = 0; j <partiesCount; j++){
                parties.add(new Party(sc.nextInt(), (char) charNumber));
                charNumber++;
            }
            while(parties.size()!=0){
                int initialSize = parties.size();
                Party first = parties.first();
                first.count-=1;
                if(first.count == 0){
                    parties.remove(first);
                }
                System.out.print(first.name);
                if(initialSize%2==0){
                    Party second = parties.first();
                    second.count-=1;
                    if(second.count == 0){
                        parties.remove(second);
                    }
                    System.out.print(second.name);
                }
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
    
}

class Party{
    int count;
    char name;
    
    Party(int count, char name){
        this.name = name;
        this.count = count;
    }
    
}