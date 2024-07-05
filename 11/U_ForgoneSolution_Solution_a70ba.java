import java.util.LinkedList;
import java.util.Scanner;

public class U_ForgoneSolution_Solution_a70ba {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
       
        int cases = scan.nextInt();
        for(int i = 0; i < cases; i++){
            scan.nextLine();
            solveFor(scan.nextInt(), i+1);
        }
    }
    
    public static void solveFor(int n, int caseNumber) {
        int number = n;
        LinkedList<Integer> reverseNumberStack = new LinkedList<Integer>();
        
        while (number > 0){
            reverseNumberStack.push(number % 10);
            number = number / 10;
        }
        
        int a = 0, b = 0;
        int i = 1;
        int temp;

        while (!reverseNumberStack.isEmpty()) {
            temp = reverseNumberStack.pop();
            if(temp == 4){
                a += ((temp-1) * i);
                b +=  (1 * i);
            }else if(temp == 0){
              a = a*10;
            }else{
                a += temp *i;
            }
            i = i*10;
        }
        
        System.out.println("Case #"+caseNumber+": "+a+" "+b);
    }
}