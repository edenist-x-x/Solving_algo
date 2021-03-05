package BojAlgorithms;

import java.util.Scanner;

public class no2167 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int i, j, x, y;
        int[][] arr = new int[n][m];

        for(int a = 0; a < arr.length; a++){ // 배열에 담기
            for(int b = 0; b < arr[a].length; b++){
                arr[a][b] = sc.nextInt();
            }
        }
        int line = sc.nextInt();
        for(int a = 0; a < line; a++){
            i = sc.nextInt() - 1;
            j = sc.nextInt() - 1;
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
            int sum = 0;
            for(int b = i; b <= x; b++){
                for(int c = j; c <= y; c++){
                    sum += arr[b][c];
                }
            }
            System.out.println(sum);
        }
    }
}
