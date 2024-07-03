import java.io.BufferedInputStream;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution_b1577 {
	static final boolean PARALLEL = false;
	
	static final Scanner in = new Scanner(new BufferedInputStream(System.in));
	
	public static void main(String[] args) {
		List<Case> c = IntStream.rangeClosed(1, in.nextInt()).mapToObj(i -> new Case()).collect(Collectors.toList());
		List<String> results = (PARALLEL ? c.parallelStream() : c.stream()).map(Case::run).collect(Collectors.toList());
		for (int i = 0; i < results.size(); i++) System.out.println("Case #" + (i+1) + ": " + results.get(i));
	}
	
	static class Case {
		// input variables
		
		int N;
		String P;
		
		Case() {
			// read input
			N = in.nextInt();
			P = in.next();
		}
		
		String run() {
			char[] out = new char[2*N - 2];
			if (P.charAt(0) == 'E') { 
				if (P.charAt(P.length() - 1) == 'S') {
					for (int i = 0; i < out.length; i++)
						out[i] = i < N - 1 ? 'S' : 'E';
				}
				else { // other path starts and ends with E
					
					// determine row of crossing other path
					int r = charCount(P.substring(0, P.indexOf("SS")), 'S') + 1;

					for (int i = 0; i < out.length; i++)
						out[i] = i < r ? 'S' : i < r + N - 1 ? 'E' : 'S';
				}
			}
			else {
				if (P.charAt(P.length() - 1) == 'E') {
					for (int i = 0; i < out.length; i++)
						out[i] = i < N - 1 ? 'E' : 'S';
				}
				else {// other path starts and ends with S
					
					// determine row of crossing other path
					int r = charCount(P.substring(0, P.indexOf("EE")), 'E') + 1;

					for (int i = 0; i < out.length; i++)
						out[i] = i < r ? 'E' : i < r + N - 1 ? 'S' : 'E';
				}
			}
			
			
			
			return new String(out);
		}
	}
	
	
	static int charCount(String s, char ch) {
		int n = 0;
		for(char c : s.toCharArray())
			if (c == ch) n++;
		return n;
	}
	
	
}
