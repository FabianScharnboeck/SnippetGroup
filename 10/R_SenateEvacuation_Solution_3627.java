package gcj2018.practise_session.senate_evacuation;

import java.util.Scanner;
class Solution_3627{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int max,k1,k2;
        int T = sc.nextInt();
        int n;
        int[] t = new int[30];
        for(int i=1;i<=T;i++){
            n = sc.nextInt();
            for(int j=0;j<n;j++){
                t[j] = sc.nextInt();
            }
            /*max = t[0];
            k1 =0 ;
            for(int j=1;j<n;j++){
                if(t[j]>max){
                    max = t[j];
                    k1 = j;
                }
            }
            max = t[0];
            k2 = 0;
            if(k2==k1){
                max = t[1];
                k2 = 1;
            }
            for(int j=0;j<n;j++){
                if(j==k1||j==k2) continue;
                if(t[j]>max){
                    max = t[j];
                    k2 = j;
                }
            }*/
            System.out.println("Case #"+i+": hhhh");
        }
    }
}