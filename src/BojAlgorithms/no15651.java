package BojAlgorithms;

import java.io.*;
import java.util.StringTokenizer;

public class no15651 {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[] nums;
    static int[] res;
    public static void duplicatedPermutation(int cnt){
        if (cnt == M) {
            for(int i = 0; i < res.length; i++){
                sb.append(res[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 1; i < N + 1; i++){
            res[cnt] = nums[i];

            duplicatedPermutation(cnt + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N + 1];
        res = new int[M];
        for(int i = 1; i < N + 1; i++){
            nums[i] = i;
        }
        duplicatedPermutation(0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
