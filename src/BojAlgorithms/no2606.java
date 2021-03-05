package BojAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class no2606 {
    static int N, M;
    static boolean[] v;
    static int[][] map;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int start = 1;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = map[b][a] = 1;
        }

        v = new boolean[N + 1];

        bfs();
        System.out.println(cnt);
    }
    public static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        v[start] = true;

        while (!q.isEmpty()) {
            int tmp = q.poll();

            for(int i = 1; i <= N; i++){
                if (map[tmp][i] == 1 && !v[i]) {
                    q.offer(i);
                    v[i] = true;
                    cnt++;
                }
            }
        }
    }
}
