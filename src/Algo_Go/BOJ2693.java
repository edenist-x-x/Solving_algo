package Algo_Go;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2693 {
    static int N = 3;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] res = new int[T];

        for(int tc = 0; tc < T; tc++){
            int[] arr = new int[10];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 10; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            res[tc] = arr[10 - N];
            System.out.println(res[tc]);
        }

    }
}
