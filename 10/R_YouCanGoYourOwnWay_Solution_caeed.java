import java.util.Scanner;

public class Solution_caeed{  
  public static void main(String[] args){
    
    Scanner sc = new Scanner(System.in);
    
    int T = sc.nextInt();
    for (int i=0; i!=T; i+=1){
      int N = sc.nextInt();
      boolean[][] grid = new boolean[N][N];
      
      String path = sc.next();
      
      // creating the path
      int row = 0;
      int col = 0;
      grid[0][0] = true;
      for (int j=0; j!=(2*N-2); j+=1){
        if (path.charAt(j) == 'E'){
          grid[row][++col] = true;
        }
        else{
          grid[++row][col] = true;
        }
      }// path created
      
//      for (int j=0; j!=N; j+=1){
//        for (int k=0; k!=N; k+=1){
//          System.out.print(grid[j][k]+ " ");
//        }
//        System.out.printf("\n");
//      }
      
      int row2 = 0;
      int col2 = 0;
      boolean current = grid[row2][col2];
      boolean east = grid[row2][col2+1];
      boolean south = grid[row2+1][col2];
      String path2 = "";
      boolean went_south = true;  // since we'll start by going east
      
      while(true){
        
        if (row2 == N-1){
          path2 += "E";
          break;
        }
        if (col2 == N-1){
          path2 += "S";
          break;
        }
        
        current = grid[row2][col2];
        east = grid[row2][col2+1];
        south = grid[row2+1][col2];
        
        if (went_south){
          if (!(current && east)){
            col2 += 1;
            path2 += "E";
            went_south = false;
          }
          else{
            row2 += 1;
            path2 += "S";
          }
        }
        else{  //meaning I moved east last time
          if (!(current && south)){
            row2 += 1;
            path2 += "S";
            went_south = true;
          }
          else{
            col2 += 1;
            path2 += "E";
          }
        }
        
      }
      
      System.out.printf("Case #%d: %s\n", i+1, path2);
      
    }
  }
  
}






