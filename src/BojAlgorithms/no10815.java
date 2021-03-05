package BojAlgorithms;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){ // 이분탐색, 음수 양수 구분해서
                int min = 0;
                int max = N - 1;
                int res = 0;
            int mNum = Integer.parseInt(st.nextToken());
            while (min <= max) {
                int mid = (min + max) / 2;
                if (arr[mid] == mNum) {
                    res = 1;
                    break;
                }
                if (arr[mid] > mNum) {
                    max = mid - 1;
                }
                else min = mid + 1;
            }
            sb.append(res).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
