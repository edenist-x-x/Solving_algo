package BojAlgorithms;

import java.io.*;
import java.util.StringTokenizer;

public class no15652 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static int[] nums;
    static int[] res;

    public static void nondupliC(int cnt, int start){
        if (cnt == M) {
            for (int re : res) {
                sb.append(re).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = start; i < nums.length; i++){
            res[cnt] = nums[i];
            nondupliC(cnt + 1, i);
        }
    }
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N + 1];
        res = new int[M];

        for(int i = 1; i < nums.length; i++){
            nums[i] = i;
        }

        nondupliC(0, 1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}
