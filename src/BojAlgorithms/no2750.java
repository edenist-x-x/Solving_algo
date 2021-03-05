/*
*
* BOJ_2750 수 정렬하기
* */
package BojAlgorithms;

import java.io.*;
import java.util.Arrays;

public class no2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];

        for(int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            sb.append(nums[i]).append("\n");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
