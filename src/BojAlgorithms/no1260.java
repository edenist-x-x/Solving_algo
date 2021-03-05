package BojAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class no1260 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M, V;
    static int[][] map;
    static boolean[] checked;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        map = new int[1001][1001];
        checked = new boolean[1001];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = map[b][a] = 1;
        }

        dfs(V);
        checked = new boolean[1001];

        System.out.println();

        bfs();
    }

    public static void dfs(int idx) {
        checked[idx] = true;
        System.out.print(idx + " ");

        for(int i = 1; i <= N; i++){
            if (map[idx][i] == 1 && !checked[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(){
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(V);
        checked[V] = true;
        System.out.print(V + " ");

        while (!q.isEmpty()) {
            int tmp = q.poll();

            for(int i = 1; i <= N; i++){
                if (map[tmp][i] == 1 && !checked[i]) {
                    checked[i] = true;
                    q.offer(i);
                    System.out.print(i + " ");
                }
            }
        }
    }
}
