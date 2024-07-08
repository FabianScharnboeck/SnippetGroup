import java.util.Scanner;

public class U_ForgoneSolution_Solution_b8625 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int T = s.nextInt();
        
        for(int i = 1; i <= T; i++){
            int num = s.nextInt();
            
            for(int j = 0; j < num; j++){
                if(!containsFour(j) && !containsFour(num-j)){
                    System.out.println(String.format("Case #%d: %d %d", i, j, num-j));
                    break;
                }
            }
        }
    }
    
    private static boolean containsFour(int number){
        while(number != 0){
            if(number % 10 == 4)
                return true;
            
            number /= 10;
        }
        
        return false;
    }
}