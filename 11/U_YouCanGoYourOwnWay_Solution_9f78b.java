import java.util.Scanner;

public class U_YouCanGoYourOwnWay_Solution_9f78b {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numInputs = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < numInputs; i++) {

            int length = Integer.parseInt(sc.nextLine());

            System.out.printf("Case #%d: %s\n", i+1, findPath(sc.nextLine()));

        }

    }

    //the problem is that we may run out of moves on the last move forcing us to follow the same path
    public static String findPath(String s) {

        /*String tempE = "";
        String tempS = "";
        for (int i = 0; i < s.length()/2; i++) {
            tempE += "E";
            tempS += "S";
        }

        if(s.substring(0, s.length()/2).equals(tempE)) {
            String output = "";
            for (int i = 0; i < s.length(); i++)
                output += i%2 == 0 ? "S" : "E";
            return output;
        } else if(s.substring(0, s.length()/2).equals(tempS)) {
            String output = "";
            for (int i = 0; i < s.length(); i++)
                output += i%2 == 0 ? "E" : "S";
            return output;
        }*/

        char[] in = s.toCharArray();
        char[] out = s.toCharArray();

        int myX = 0, myY = 0, otherX = 0, otherY = 0;

        //switch character at beginning

        int index = 0;

        for (int i = 1; i < out.length; i++) {

            if (out[0] != out[i]) {
                index = i;
                break;
            }

        }

        char temp = out[0];
        out[0] = out[index];
        out[index] = temp;

        if (out[out.length-1] == in[in.length-1]) {

            index = out.length - 1;
            for (int i = out.length - 2; i > 0; i--) {

                if (out[out.length - 1] != out[i]) {
                    index = i;
                    break;
                }

            }

            temp = out[out.length - 1];
            out[out.length - 1] = out[index];
            out[index] = temp;

        }

        for (int i = 0; i < in.length-2; i++) {

            if (myX == otherX && myY == otherY && in[i] == out[i] && i > 1) {

                System.out.println("Same location");

                index = i;

                for (int j = i+1; j < out.length-1; j++) {

                    if (out[i] != out[j]) {
                        index = j;
                        break;
                    }

                }

                temp = out[i];
                out[i] = out[index];
                out[index] = temp;

            }

            if (out[i] == 'E')
                myX++;
            else
                myY++;

            if (in[i] == 'E')
                otherX++;
            else
                otherY++;

        }

        return new String(out);

    }

}
