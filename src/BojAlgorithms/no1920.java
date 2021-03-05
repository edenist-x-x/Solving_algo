/*
*
* BOJ_1920 수 찾기
*
* */

package BojAlgorithms;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] an = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < an.length; i++){
            an[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(an);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int res = 0;
            int min = 0;
            int max = N - 1;
            int nums = Integer.parseInt(st.nextToken());
            while (min <= max) {
                int mid = (min + max) / 2;
                if (an[mid] == nums) {
                    res = 1;
                    break;
                }
                if (an[mid] > nums) {
                    max = mid - 1;
                }
                else min = mid + 1;
            }
            sb.append(res).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
