package Algo_Go;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5598 {
    public static void main(String[] args) throws IOException {
        char[] before = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] after =  {'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C'};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String ipt = br.readLine();
        String res = "";

        for(int i = 0; i < ipt.length(); i++){
            if(ipt.charAt(i) - 65 - 3 >= 0){
                res += before[ipt.charAt(i) - 65 - 3];
            }
            else {
                res += before[before.length + (ipt.charAt(i) - 65 - 3)];
            }
        }

//        System.out.println(ipt.charAt(0) - 65 - 3);
//        System.out.println(before.length);
//        System.out.println(before[before.length + (ipt.charAt(0) - 65 - 3)]);

        System.out.println(res);
    }
}
