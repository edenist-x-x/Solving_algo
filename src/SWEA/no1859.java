package SWEA;

import java.io.*;
import java.util.*;

public class no1859 {
    static int N;
    static int[] nums;
    static Stack<Integer> stack = new Stack<>();
    static int[] sums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;
            for (int i = 0; i < N; i++) {
                int n = Integer.parseInt(st.nextToken());

                int cnt = 0;
                stack.push(n);
                if (stack.size() > 1) {
                    if (stack.peek() < n) {
                        sum += stack.pop();
                        cnt++;
                    }
                    if (stack.peek() > n) {

                    }
                }


            }
            int res = 0;
        }
    }
}
