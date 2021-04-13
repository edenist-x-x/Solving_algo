package BojAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class no9205 {
    static int N;
    static Point[] p;
    static boolean[][] map;
    static boolean[] v;
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++){
            N = Integer.parseInt(br.readLine());

            q = new LinkedList<>();
            map = new boolean[N + 2][N + 2];
            p = new Point[N + 2];
            v = new boolean[N + 2];

            for(int n = 0; n < N + 2; n++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                p[n] = new Point(x, y);
            }

            for(int i = 0; i < N + 2; i++){
                for(int j = 0; j < N + 2; j++){
                    if (Math.abs(p[i].x - p[j].x) + Math.abs(p[i].y - p[j].y) <= 1000) {
                        map[i][j] = true;
                        map[j][i] = true;
                    }
                }
            }
            if (bfs()) {
                System.out.println("happy");
            }else
                System.out.println("sad");
        }
    }

    static boolean bfs(){
        q.offer(0);
        v[0] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();

            for(int i = 1; i < N + 2; i++){
                if(!map[cur][i]) continue;
                if(i == N + 1) return true;
                if (!v[i]) {
                    v[i] = true;
                    q.offer(i);
                }
            }
        }
        return false;
    }
    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
