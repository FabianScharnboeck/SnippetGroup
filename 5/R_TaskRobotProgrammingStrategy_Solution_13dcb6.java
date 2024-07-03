import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class R_TaskRobotProgrammingStrategy_Solution_13dcb6
{
  private static int t;
  private static int task;
  private static Scanner in;

  public static void main(String[] args) throws Exception
  {
    in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    t = in.nextInt();
    for (int i = 1; i <= t; ++i)
    {
      task = i;
      solve();
    }
  }

  private static void solve()
  {

    int a = in.nextInt();
    // String[] c = new String[a];
    List<String> c = new ArrayList<>();
    for (int i = 0; i < a; i++)
    {
      c.add(in.next());
    }

    String win = "";
    for (int i = 0; i < 3 * 500; i++)
    {
      Set<Character> cs = new HashSet<>();
      List<Integer> r = new ArrayList<>();
      List<Integer> p = new ArrayList<>();
      List<Integer> s = new ArrayList<>();
      for (int j = 0; j < c.size(); j++)
      {
        if (c.get(j) != null)
        {
          char op = c.get(j).charAt(i % c.get(j).length());
          if (op == 'R')
            r.add(j);
          else if (op == 'P')
            p.add(j);
          else if (op == 'S')
            s.add(j);

          cs.add(op);
        }
      }
      if (cs.size() == 3)
      {
        System.out.println("Case #" + task + ": IMPOSSIBLE");
        return;
      }
      else if (cs.size() == 2)
      {
        if (cs.contains('P') && cs.contains('R'))
        {
          win += 'P';
          for (int j = 0; j < r.size(); j++)
          {
            int idx = r.get(j);
            c.set(idx, null);
          }
        }
        else if (cs.contains('P') && cs.contains('S'))
        {
          win += 'S';
          for (int j = 0; j < p.size(); j++)
          {
            int idx = p.get(j);
            c.set(idx, null);
          }
        }
        else if (cs.contains('R') && cs.contains('S'))
        {
          win += 'R';
          for (int j = 0; j < s.size(); j++)
          {
            int idx = s.get(j);
            c.set(idx, null);
          }
        }
      }
      else if (cs.size() == 1)
      {
        if (cs.contains('P'))
          win += 'S';
        else if (cs.contains('R'))
          win += 'P';
        else if (cs.contains('S'))
          win += 'R';

        System.out.println("Case #" + task + ": " + win);
        return;
      }
    }
    System.out.println("Case #" + task + ": IMPOSSIBLE");
  }

}