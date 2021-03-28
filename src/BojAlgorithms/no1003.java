package BojAlgorithms;

import java.io.*;

public class no1003 {
    static int[][] dp = new int[41][2];
    static int N;
    static int[] v = new int[41];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){
            N = Integer.parseInt(br.readLine());

            fibonacci(N);
            for(int i = 2; i <= N; i++){
                dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
                dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
            }
            sb.append(dp[N][0]).append(" ").append(dp[N][1]).append("\n");

        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static int fibonacci(int n) {
        if(n == 0) return 0;
        else if(n == 1) return 1;
        if(v[n] != 0) return v[n];
        else return v[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }
}
