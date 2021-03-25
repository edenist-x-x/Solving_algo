package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class no3307 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            int N = sc.nextInt();

            int[] map = new int[N];
            int[] LIS = new int[N];

            for(int i = 0; i < N; i++){
                map[i] = sc.nextInt();
            }

            Arrays.fill(LIS, 1);

            int max = 0;
            for(int i = 1; i < N; i++){
//                LIS[i] = 1;
                for(int j = 0; j < i; j++){
                    if (map[j] < map[i] && LIS[i] < LIS[j] + 1) {
                        LIS[i] = LIS[j] + 1;
                    }
                }
                if(max < LIS[i]) max = LIS[i];
            }
            System.out.println("#" + tc + " " + max);
        }
    }

}
