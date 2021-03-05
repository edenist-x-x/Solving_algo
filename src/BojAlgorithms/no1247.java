package BojAlgorithms;

import java.util.Scanner;

public class no1247 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[] sum = new long[3];

        int i = 0;
        for(i = 0; i < 3; i++){
            int n = sc.nextInt();
            for(int j = 0; j < n; j++){
                long num = sc.nextLong();
                sum[i] += num;
            }
        }
        for(int k = 0; k < sum.length; k++){
            if(sum[k] == 0){
                System.out.println("0");
            }
            else if(sum[k] > 0){
                System.out.println("+");
            }
            else if(sum[k] < 0)
                System.out.println("-");
        }
    }
}
