package BojAlgorithms;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no15654 {
    static int N, M;
    static int[] nums;
    static int[] res;
    static boolean[] check;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void permutation(int cnt){
        if (cnt == M) {
            for(int i = 0; i < res.length; i++){
                sb.append(res[i] + " ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 0; i < N; i++){
            if(check[i]) continue;
            res[cnt] = nums[i];
            check[i] = true;

            permutation(cnt + 1);
            check[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        check = new boolean[N];
        res = new int[M];

        permutation(0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
