import java.util.*;
import java.io.*;
public class Solution_bc5c8 {
	static int[][] grid;
	static String output_path;
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int size = in.nextInt();
			grid = new int[size +1][size +1]; //prevent out of bound
			String path = in.next();
			output_path = "";
			int x = 0;
			int y = 0;
			for (int j =0; j<path.length(); j++){
				if(path.charAt(j) == 'S') {grid[x][++y] = 1;}
				else {grid[++x][y] = 1;}
			}

			path_check(path, "", size, 0,0,0);

			System.out.println("Case #" + i + ": " + output_path);
		}
	}


	private static void path_check(String original_path, String curr_path, int size, int x, int y, int path_count){

		if (x == size-1 && y == size-1) {output_path = curr_path; return;}
		if (x >= size || y >= size) return;
		//if (path_count >= size) return;

		if(grid[x][y+1] == 1 && original_path.charAt(path_count) == 'S') // go east 
			path_check(original_path, curr_path+"E", size, x+1, y, path_count+1);
		else if(grid[x+1][y] == 1 && original_path.charAt(path_count) == 'E') // go south 
			path_check(original_path, curr_path+"S", size, x, y+1, path_count+1);
		else {
			path_check(original_path, curr_path+"S", size, x, y+1, path_count+1);
			path_check(original_path, curr_path+"E", size, x+1, y, path_count+1);
		}
	}

}