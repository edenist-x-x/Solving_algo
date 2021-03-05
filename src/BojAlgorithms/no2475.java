package BojAlgorithms;

import java.util.Scanner;

public class no2475 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] num = new int[5];
        int sum = 0;
        int i = 0;
        int result = 0;

        for(i = 0; i < num.length; i++){
            num[i] = sc.nextInt();
            num[i] *= num[i];
        }
        for(int j = 0; j < num.length; j++){
            sum += num[i];
        }
        result = sum % num.length;

        System.out.println(result);
    }
}
