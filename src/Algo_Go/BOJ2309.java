package Algo_Go;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2309 {
    public static void main(String[] args) throws IOException {
        int[] arr = new int[9];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        for(int i = 0; i < 9; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        int nonSum = sum - 100;
        int nonA = 0;
        int nonB = 0;

        Arrays.sort(arr);

        for(int i = 0; i < 8; i++){
            for(int j = i + 1; j < 9; j++){
                if (arr[i] + arr[j] == nonSum) {
                    nonA = arr[i];
                    nonB = arr[j];
                }
            }
        }

        for(int i = 0; i < 9; i++){
            if(arr[i] == nonA || arr[i] == nonB){
                arr[i] = 100;
            }
        }
        Arrays.sort(arr);
        for(int i = 0; i < 9; i++){
            if(arr[i] != 100){
                System.out.println(arr[i]);
            }
        }
    }
}
