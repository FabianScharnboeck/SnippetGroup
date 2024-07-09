import java.util.*;
import java.io.*;
public class Solution_13de52{
    public static String fit(String s, int tar){
        String ans = s;
        int len = s.length();
        for(int i = 0; i < tar/len; i++){
            ans += s;
        }
        return ans;
    }
    public static String trim(String s, int len){
        return s.substring(0,len);
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int test = scan.nextInt();
        for(int i = 0; i<test; i++){
            int total = scan.nextInt();
            scan.nextLine();
            ArrayList<String> strats = new ArrayList<String>();
			for(int j = 0; j<total; j++){
			    String strat = scan.nextLine();
			    strats.add(trim(fit(strat,500),500));
			}
			String ans = "";
			for(int j = 0; j<500; j++){
			    boolean rock = false;
			    boolean paper = false;
			    boolean scissors = false;
			    for(int k = 0; k<strats.size();k++){
		            if(strats.get(k).substring(j,j+1).equals("R")) rock = true;
		            else if(strats.get(k).substring(j,j+1).equals("P")) paper = true;
		            else if(strats.get(k).substring(j,j+1).equals("S")) scissors = true;
			    }
			    if(rock && paper && scissors){
			        ans = "IMPOSSIBLE";
			        break;
			    }
			    if(rock&&paper){
                    ans += "P";
			        for(int k = 0; k<strats.size();k++){
		                if(strats.get(k).substring(j,j+1).equals("R")){
		                    strats.remove(k);
		                    k--;
		                }
		            }	                   
			    }else if(paper && scissors){
			        ans += "S";
			        for(int k = 0; k<strats.size();k++){
		                if(strats.get(k).substring(j,j+1).equals("P")){
		                    strats.remove(k);
		                    k--;
		                }
		            }	                   
			    }else if(rock && scissors){
			        ans += "R";
			        for(int k = 0; k<strats.size();k++){
		                if(strats.get(k).substring(j,j+1).equals("S")){
		                    strats.remove(k);
		                    k--;
		                }
		            }	                   
			    }else if(rock){
			        ans += "P";
			        break;
			    }else if(paper){
			        ans += "S";
			        break;
			    }else if(scissors){
			        ans += "R";
			        break;
			    }
			}
            System.out.println("Case #"+(i+1)+": "+ans);
        }
    }
}