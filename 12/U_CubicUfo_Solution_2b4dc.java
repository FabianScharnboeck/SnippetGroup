import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class U_CubicUfo_Solution_2b4dc {

	public static void main(final String[] args) {
		final FastReader in = new FastReader();
		final int numTests = in.nextInt();
		for (int i = 0; i < numTests; i++) {
			final double area = in.nextDouble();
			final List<Coordinate> coords = solve(area);
			printResult(i + 1, coords);
		}
	}

	static List<Coordinate> solve(final double area) {
		double minAngle = 0;
		double maxAngle = Math.PI / 4;
		double angle = (maxAngle - minAngle) / 2;
		double calcedArea = calcArea(angle);
		while (!isCloseEnough(area, calcedArea)) {
			if (calcedArea < area) {
				minAngle = angle;
			} else {
				maxAngle = angle;
			}
			angle = (maxAngle + minAngle) / 2;
			calcedArea = calcArea(angle);
		}
		// System.out.println("calced area = " + calcedArea);
		final List<Coordinate> result = new ArrayList<>(3);
		final double firstX = Math.cos(angle) * .5;
		final double firstY = Math.sin(angle) * .5;
		final double firstZ = 0;
		result.add(new Coordinate(firstX, firstY, firstZ));
		final double complementAngle = (Math.PI / 2) - angle;
		final double secondX = Math.cos(complementAngle) * -.5;
		final double secondY = Math.sin(complementAngle) * .5;
		final double secondZ = 0;
		result.add(new Coordinate(secondX, secondY, secondZ));
		final double thirdX = 0;
		final double thirdY = 0;
		final double thirdZ = .5;
		result.add(new Coordinate(thirdX, thirdY, thirdZ));
		return result;
	}

	static List<Coordinate> solve2(final double area) {
		final List<Coordinate> result = new ArrayList<>(3);
		final double angle = (area - 1) * (Math.PI / 4) / (Math.sqrt(2) - 1);
		final double firstX = Math.cos(angle) * .5;
		final double firstY = Math.sin(angle) * .5;
		final double firstZ = 0;
		result.add(new Coordinate(firstX, firstY, firstZ));
		final double complementAngle = (Math.PI / 2) - angle;
		final double secondX = Math.cos(complementAngle) * -.5;
		final double secondY = Math.sin(complementAngle) * .5;
		final double secondZ = 0;
		result.add(new Coordinate(secondX, secondY, secondZ));
		final double thirdX = 0;
		final double thirdY = 0;
		final double thirdZ = .5;
		result.add(new Coordinate(thirdX, thirdY, thirdZ));
		return result;
	}

	static double calcArea(final double angle) {
		final double complementAngle = (Math.PI / 4) - angle;
		final double hyp = Math.sqrt(Math.pow(.5, 2) + Math.pow(.5, 2));
		final double area = 2 * Math.cos(complementAngle) * hyp;
		return area;
	}

	static boolean isCloseEnough(final double a, final double b) {
		return Math.abs(a - b) < .0000001;
	}

	static class Coordinate {
		double x;
		double y;
		double z;

		public Coordinate(final double x, final double y, final double z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}

		@Override
		public String toString() {
			return x + " " + y + " " + z;
		}
	}

	static void printResult(final int test, final List<Coordinate> coords) {
		System.out.println("Case #" + test + ":");
		coords.stream().forEachOrdered(System.out::println);
	}

	static class FastReader {
		BufferedReader br;
		StringTokenizer st;

		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (final IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (final IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}

}
