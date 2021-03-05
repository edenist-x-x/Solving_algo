/*
*
* BOJ 20546 기적의 매매법
*
* */

package BojAlgorithms;

import java.util.Scanner;

public class no20546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int C = sc.nextInt();
        int[] duck = new int[14];
        int[] J = new int[2];
        int[] S = new int[2];
        for(int i = 0; i < duck.length; i++){
            duck[i] = sc.nextInt();
        }
        J[0] = C;
        S[0] = C;
        for(int i = 0; i < duck.length; i++){
            if(J[0] < duck[i]) continue;
            if (J[0] / duck[i] > 0) {
                J[1] += J[0] / duck[i];
                J[0] %= duck[i];
            }
        }
        for(int i = 3; i < duck.length; i++){
            if (duck[i - 3] > duck[i - 2] && duck[i - 2] > duck[i - 1] && duck[i - 1] > duck[i]) {
                S[1] += S[0] / duck[i];
                S[0] %= duck[i];
            }
            if (duck[i - 3] < duck[i - 2] && duck[i - 2] < duck[i - 1] && duck[i - 1] < duck[i]) {
                S[0] += S[1] * duck[i];
                S[1] = 0;
            }
        }
        int i = S[0] + duck[13] * S[1];
        int j = J[0] + duck[13] * J[1];
        if (j > i) {
            System.out.println("BNP");

        }
        else if (j < i){
            System.out.println("TIMING");
        }
        else
            System.out.println("SAMESAME");
    }
}
