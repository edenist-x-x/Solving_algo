package BojAlgorithms;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no15656 {
    static int N, M;
    static int[] nums;
    static int[] res;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    public static void dupliP(int cnt) {
        if (cnt == M) {
            for(int i = 0; i < res.length; i++){
                sb.append(res[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 0; i < nums.length; i++){
            res[cnt] = nums[i];

            dupliP(cnt + 1);
        }
    }
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        res = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        dupliP(0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
