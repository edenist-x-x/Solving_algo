package BojAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no11724 {
    static int N, M;
    static int[][] map = new int[1001][1001];
    static boolean[] v = new boolean[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            map[u][v] = map[v][u] = 1;
        }
        int res = 0;

        for(int i = 1; i <= N; i++){
            if(!v[i]){
                res++;
                dfs(i);
            }
        }
        System.out.println(res);
    }
    private static void dfs(int idx) {
        if(v[idx]) return;
        else{
            v[idx] = true;
            for(int j = 1; j <= N; j++){
                if(map[idx][j] == 1) dfs(j);
            }
        }
    }
}
