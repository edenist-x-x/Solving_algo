package BojAlgorithms;

import java.io.*;
import java.util.StringTokenizer;

public class no11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        int[] dp = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;

        for(int i = 1; i < N; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if (nums[j] < nums[i] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        int res = 0;

        for (int i : dp) {
            res = Math.max(i, res);
        }
        sb.append(res);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
