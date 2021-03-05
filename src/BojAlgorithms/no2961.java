package BojAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no2961 {
    static int N;
    static int[][] gre;
    static boolean[] v;
    static int res = 999999999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        gre = new int[N][2];
        v = new boolean[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            gre[i][0] = Integer.parseInt(st.nextToken());
            gre[i][1] = Integer.parseInt(st.nextToken());
        }
        c(0, 1, 0);

        System.out.println(res);

    }
    public static void c(int cnt, int s, int b) {
        if (cnt == N) {
            if (b != 0) {
                res = Math.min(res, Math.abs(s - b));
            }
            return;
        }
        v[cnt] = true;
        c(cnt + 1, s * gre[cnt][0], b + gre[cnt][1]);
        v[cnt] = false;
        c(cnt + 1, s, b);
    }
}
