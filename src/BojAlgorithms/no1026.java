package BojAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class no1026 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        int[] b = new int[N];

        for(int i = 0; i < a.length; i++){
            a[i] = sc.nextInt();
        }
        for(int i = 0; i < b.length; i++){
            b[i] = sc.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int res = 0;
        for(int i = 0; i < N; i++){
            res += a[i] * b[N - i - 1];
        }

        System.out.println(res);
    }
}
