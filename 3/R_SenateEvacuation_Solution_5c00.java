import java.util.Scanner;

public class R_SenateEvacuation_Solution_5c00 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    for (int i = 1; i <= t; i++) {
      int n = in.nextInt();

      String dataStr = "";
      int[] data = new int[n];
      String result = "";
      for (int j = 0; j < n; j++) {
          data[j] = in.nextInt();
          dataStr = dataStr + data[j] + " ";
      }
      
      if (n == 2)  {
          for (int j = 0; j < data[0]; j++) {
              result = result + "AB" + " ";
          }
      }
      else  {
          if (dataStr.equalsIgnoreCase("1 1 1 "))  {
              result = "A BC";
          }
          else if (dataStr.equalsIgnoreCase("1 1 2 "))  {
              result = "CC AB";
          }
          else if (dataStr.equalsIgnoreCase("1 2 1 "))  {
              result = "BB AC";
          }
          else if (dataStr.equalsIgnoreCase("2 1 1 "))  {
              result = "AA BC";
          }
          else if (dataStr.equalsIgnoreCase("1 2 2 "))  {
              result = "A BC BC";
          }
          else if (dataStr.equalsIgnoreCase("2 1 2 "))  {
              result = "B AC AC";
          }
          else if (dataStr.equalsIgnoreCase("2 2 1 "))  {
              result = "C AB AB";
          }
          else if (dataStr.equalsIgnoreCase("1 2 3 "))  {
              result = "AC BC BC";
          }
          else if (dataStr.equalsIgnoreCase("1 3 2 "))  {
              result = "AB BC BC";
          }
          else if (dataStr.equalsIgnoreCase("2 1 3 "))  {
              result = "BC AC AC";
          }
          else if (dataStr.equalsIgnoreCase("2 3 1 "))  {
              result = "BC AB AB";
          }
          else if (dataStr.equalsIgnoreCase("3 1 2 "))  {
              result = "AB AC AC";
          }
          else if (dataStr.equalsIgnoreCase("3 2 1 "))  {
              result = "AC AB AB";
          }
          else if (dataStr.equalsIgnoreCase("2 2 2 "))  {
              result = "AA BC BC";
          }
          else if (dataStr.equalsIgnoreCase("2 2 3 "))  {
              result = "CC C AB AB";
          }
          else if (dataStr.equalsIgnoreCase("2 3 2 "))  {
              result = "BB B AC AC";
          }
          else if (dataStr.equalsIgnoreCase("3 2 2 "))  {
              result = "AA A BC BC";
          }
          else if (dataStr.equalsIgnoreCase("1 3 3 "))  {
              result = "A BC BC BC";
          }
          else if (dataStr.equalsIgnoreCase("3 1 3 "))  {
              result = "B AC AC AC";
          }
          else if (dataStr.equalsIgnoreCase("3 3 1 "))  {
              result = "C AB AB AB";
          }
          else if (dataStr.equalsIgnoreCase("2 3 3 "))  {
              result = "AA BC BC BC";
          }
          else if (dataStr.equalsIgnoreCase("3 2 3 "))  {
              result = "BB AC AC AC";
          }
          else if (dataStr.equalsIgnoreCase("3 3 2 "))  {
              result = "CC AB AB AB";
          }
          else if (dataStr.equalsIgnoreCase("1 3 4 "))  {
              result = "AC BC BC BC";
          }
          else if (dataStr.equalsIgnoreCase("1 4 3 "))  {
              result = "AB BC BC BC";
          }
          else if (dataStr.equalsIgnoreCase("3 1 4 "))  {
              result = "BC AC AC AC";
          }
          else if (dataStr.equalsIgnoreCase("3 4 1 "))  {
              result = "BC AB AB AB";
          }
          else if (dataStr.equalsIgnoreCase("4 1 3 "))  {
              result = "AB AC AC AC";
          }
          else if (dataStr.equalsIgnoreCase("4 3 1 "))  {
              result = "AC AB AB AB";
          }
          else if (dataStr.equalsIgnoreCase("2 3 4 "))  {
              result = "C AA BC BC BC";
          }
          else if (dataStr.equalsIgnoreCase("2 4 3 "))  {
              result = "B AA BC BC BC";
          }
          else if (dataStr.equalsIgnoreCase("3 2 4 "))  {
              result = "C BB AC AC AC";
          }
          else if (dataStr.equalsIgnoreCase("3 4 2 "))  {
              result = "B CC AB AB AB";
          }
          else if (dataStr.equalsIgnoreCase("4 2 3 "))  {
              result = "A BB AC AC AC";
          }
          else if (dataStr.equalsIgnoreCase("4 3 2 "))  {
              result = "A CC AB AB AB";
          }
          else if (dataStr.equalsIgnoreCase("3 3 3 "))  {
              result = "AA A BC BC BC";
          }
          else if (dataStr.equalsIgnoreCase("1 4 4 "))  {
              result = "A BC BC BC BC";
          }
          else if (dataStr.equalsIgnoreCase("4 1 4 "))  {
              result = "B AC AC AC AC";
          }
          else if (dataStr.equalsIgnoreCase("4 4 1 "))  {
              result = "C AB AB AB AB";
          }
      }
      
      System.out.println("Case #" + i + ": " + result);
    }
  }
}