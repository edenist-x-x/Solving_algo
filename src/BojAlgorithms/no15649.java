package BojAlgorithms;

import java.io.*;
import java.util.StringTokenizer;

public class no15649 {
    static int N, M;
    static boolean[] isSelected;
    static int[] nums;
    static int[] res;
    public static void permutation(int cnt){
//        종료 조건
        if (cnt == M) {
            for (int ans : res) {
                System.out.print(ans + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 1; i < N + 1; i++){
            if(isSelected[i]) continue;
            res[cnt] = nums[i];
            isSelected[i] = true;

            permutation(cnt + 1);
            isSelected[i] = false;
        }
//        실행 & 재귀 호출
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
        isSelected = new boolean[N + 1];

        permutation(0);


    }
}
