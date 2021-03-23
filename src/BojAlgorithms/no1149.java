package BojAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] money = new int[N][3];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            money[i][0] = Integer.parseInt(st.nextToken());
            money[i][1] = Integer.parseInt(st.nextToken());
            money[i][2] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < N; i++){
            money[i][0] += Math.min(money[i - 1][1], money[i - 1][2]);
            money[i][1] += Math.min(money[i - 1][0], money[i - 1][2]);
            money[i][2] += Math.min(money[i - 1][0], money[i - 1][1]);
        }
        int temp = 0;
        temp = Math.min(money[N - 1][0], money[N - 1][1]);
        int res = Math.min(temp, money[N - 1][2]);

        System.out.println(res);
    }
}
