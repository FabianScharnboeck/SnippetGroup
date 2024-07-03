import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution_1360c9 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int test = 1 ; test <= T; ++test) {
			
			boolean isPossible = true;
			int N = sc.nextInt();
			int idx = 0;
			Set<String> P = new HashSet<String>();
			char ansChar;
			String ans = "";
			
			for (int i = 0; i < N; ++i) {
				String s = sc.next();
				
				P.add(s);
			}
			
			while (isPossible && !P.isEmpty() && ans.length() < 500) {
				
				int rCnt = 0;
				int pCnt = 0;
				int sCnt = 0;
				int zCnt = 0;
				
				for (String s : P) {
					char c = s.charAt(idx % s.length()); 
					if (c == 'R') {
						++rCnt;
					} else if (c == 'P') {
						++pCnt;
					} else {
						++sCnt;
					}
				}
				
				zCnt += (rCnt == 0 ? 1 : 0);
				zCnt += (pCnt == 0 ? 1 : 0);
				zCnt += (sCnt == 0 ? 1 : 0);
				
				ansChar = ' ';
				
				if (zCnt == 0) {
					isPossible = false;
				} else if (zCnt == 1) {
					if (rCnt == 0) { // PS
						ansChar = 'S';
					} else if (pCnt == 0) { // RS
						ansChar = 'R';
					} else { // RP
						ansChar = 'P';
					}					
				} else {
					if (rCnt != 0) {
						ansChar = 'P';
					} else if (pCnt != 0) {
						ansChar = 'S';
					} else {
						ansChar = 'R';
					}
				}
				
				Set<String> delS = new HashSet<String>();
				
				for (String s : P) {
					if (s.charAt(idx % s.length()) != ansChar) {
						delS.add(s);
					}
				}
				
				for (String s : delS) {
					P.remove(s);
				}
				
				ans += ansChar;
				
				++idx;
			}
			
			while (idx <= 25000 && isPossible && !P.isEmpty()) {
				ansChar = ans.charAt(idx % ans.length());
				
				Set<String> delS = new HashSet<String>();
				
				for (String s : P) {
					char c = s.charAt(idx % s.length());
					
					if (ansChar == c) {
						continue;
					} else if ((ansChar == 'R' && c == 'S') ||
							(ansChar == 'P' && c == 'R') ||
							(ansChar == 'S' && c == 'P')) {
						
					} else {
						isPossible = false;
					}
				}
				
				for (String s : P) {
					if (s.charAt(idx % s.length()) != ansChar) {
						delS.add(s);
					}
				}
				
				++idx;
			}
			
			if (!P.isEmpty()) {
				isPossible = false;
			}
		
			if (isPossible) {
				System.out.println("Case #" + test + ": " + ans);	
			} else {
				System.out.println("Case #" + test + ": IMPOSSIBLE");
			}
		}
		
		sc.close();
	}
}
