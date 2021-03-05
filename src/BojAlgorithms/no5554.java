package BojAlgorithms;

import java.util.Scanner;

public class no5554 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] time = new int[4];
        int sum = 0;

        for(int i = 0; i < time.length; i++){
            time[i] = sc.nextInt();
        }

        for(int i = 0; i < time.length; i++){
            sum += time[i];
        }

        System.out.println(sum / 60);
        System.out.println(sum % 60);
    }
}
