package BojAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no15650 {
    static int N, M;
    static int[] nums;
    static int[] res;
    public static void combination(int cnt, int start){
        if (cnt == M) {
            for (int re : res) {
                System.out.print(re + " ");
            }
            System.out.println();
            return;
        }
        for(int i = start; i < N + 1; i++){
            res[cnt] = nums[i];
            combination(cnt + 1, i + 1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N + 1];
        for(int i = 1; i < nums.length; i++){
            nums[i] = i;
        }
        res = new int[M];
        combination(0, 1);
    }

}
