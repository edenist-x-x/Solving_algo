package Algo_Go;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ2576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[7];
        int min = 0;
        int sum = 0;

        for(int i = 0; i < 7; i++){
            int num = Integer.parseInt(br.readLine());
            if(num % 2 != 0){
                arr[i] = num;
            } else {
                arr[i] = 100;
            }
        }
        Arrays.sort(arr);

        min = arr[0];

        for(int i = 0; i < 7; i++){
            if(arr[i] != 100){
                sum += arr[i];
            }
        }
        if(sum == 0){
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }


    }
}
