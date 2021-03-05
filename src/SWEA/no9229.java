package SWEA;

import java.util.Scanner;

public class no9229 {
    static int N;
    static int M;
    static int R = 2;
    static int[] snack;
    static int[] res;
    static int max;

    static void getG(int cnt, int start) {
        int total = 0;
        if (cnt == R) {
            total = res[0] + res[1];
            if (total > max && total <= M) {
                max = total;
            }
            return;
        }
        for(int i = start; i < N; i++){
            res[cnt] = snack[i];
            getG(cnt + 1, i + 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            N = sc.nextInt();
            M = sc.nextInt();
            snack = new int[N];
            res = new int[R];
            max = -1;
            for(int i = 0; i < N; i++){
                snack[i] = sc.nextInt();
            }
            getG(0, 0);
            System.out.println("#" + tc + " " + max);
        }
    }
}
