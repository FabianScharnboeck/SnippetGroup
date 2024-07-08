import java.io.IOException;
import java.util.Scanner;

public class U_SenateEvacuation_Solution_34a4 {
    private static char n[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P',
                                'Q','R','S','T','U','V','W','X','Y','Z'};
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String [] args) throws IOException {
        String s;
        s = scanner.nextLine();
        int t = Integer.parseInt(s);
        System.err.println("t="+t);
        String [] split;
        String [] result = new String[t];
        int [] parties; //lazy init
        String output = "";
        for(int i=0;i<t;i++)
        {
            s = scanner.nextLine();
            parties = new int[Integer.parseInt(s)];
            s = scanner.nextLine();
            split = s.split(" ");
            for(int j = 0; j<parties.length ; j++) {
                parties[j] = Integer.parseInt(split[j]);
            }
            //Output time
            output = "Case #"+(i+1)+":";
            if(parties.length == 2)
            {
                while(!allEvacuated(parties))
                    output+=removeParties(parties, 0, 1);
            }
            else {
                while(!allEvacuated(parties))
                    output+= removeLargerThenOthers(parties);
            }
            result [i] = output;
        }

        for(String out : result)
            System.out.println(out);
    }

    private static String removeLargerThenOthers(int [] parties)
    {
        String party = "";
        int indexLarger = 0;
        //Finding the largest
        for(int i=1;i<parties.length;i++)
        {
            if(parties[i]>parties[indexLarger])
                indexLarger = i;
        }
        party += removeParty(parties, indexLarger); //Removing the largest first

        //TODO: Remove the other 2
        for(int i = 0;i<parties.length;i++)
        {
            if(i == indexLarger)
                continue;
            party += removePartyOnce(parties, i);
        }

        return party;
    }

    private static String removeParty(int []parties, int i){
        String party = " ";
        if(parties[i]>=2) {
            parties[i] -= 2;
            party += n[i]+""+n[i];
        }
        else {
            parties[i]--;
            party += n[i];
        }
        return party;
    }
    private static String removePartyOnce(int []parties, int i){
        String party = " ";
        if(parties[i]>=1) {
            parties[i]--;
            party += n[i];
        }
        return party;
    }

    private static String removeParties(int []parties, int i, int j){
        String party = " ";
        if(parties[i]>=1) {
            parties[i]--;
            party+=n[i];
        }
        if(parties[j]>=1) {
            parties[j]--;
            party+=n[j];
        }
        return party;
    }


    private static boolean allEvacuated(int [] parties){
        for(int party : parties)
            if(party >0)
                return false;
        return true;
    }
}
