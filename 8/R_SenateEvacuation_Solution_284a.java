package gcj2018.practise_session.senate_evacuation;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution_284a {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		// PrintWriter w = new PrintWriter(System.out);
		int t = s.nextInt();
		int csn = 1;
		while (t-- > 0) {
			int n = s.nextInt();
			PriorityQueue<nds> q = new PriorityQueue<>(new cmp41());
			double sum = 0;
			for (int i = 0; i < n; i++) {
				int pi = s.nextInt();
				q.add(new nds(pi, i + 1));
				sum += pi;
			}
			System.out.print("Case #" + csn++ + ": ");
			while (!q.isEmpty()) {
				if (q.size() >= 2) {
					nds max1 = q.poll();
					nds max2 = q.poll();
					double ans = (sum - 2) / 2.0;
					if (ans / 2 < max2.x) {
						System.out.print((char) (64 + max1.y) + "" + (char) (64 + max2.y) + " ");
						sum -= 2;
						max1.x -= 1;
						max2.x -= 1;
						if (max1.x > 0)
							q.add(max1);
						if (max2.x > 0)
							q.add(max2);
					} else {
						q.add(max2);
						q.add(max1);
						nds max = q.poll();
						if (max.x == 1) {
							System.out.print((char) (64 + max.y) + " ");
							sum -= 1;
						} else {

							System.out.print((char) (64 + max.y) + "" + (char) (64 + max.y) + " ");
							max.x = max.x - 2;
							if (max.x != 0) {
								q.add(new nds(max.x, max.y));
							}
							sum -= 2;
						}
					}
				} else {
					nds max = q.poll();
					if (max.x == 1) {
						System.out.print((char) (64 + max.y) + " ");
						sum--;
					} else {

						System.out.print((char) (64 + max.y) + "" + (char) (64 + max.y) + " ");
						max.x = max.x - 2;
						if (max.x != 0) {
							q.add(new nds(max.x, max.y));
						}
						sum -= 2;
					}

				}
			}
			System.out.println();

		}

	}

}

class nds {
	int x, y;

	nds(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

class cmp41 implements Comparator<nds> {
	@Override
	public int compare(nds o1, nds o2) {
		// TODO Auto-generated method stub
		return o2.x - o1.x;
	}
}
