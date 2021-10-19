package BojAlgorithms;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class no2636 {
    static int N, M;
    static int[][] map;
    static boolean[][] v;
    static int time, chz, cnt;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int r = 0; r < N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
                if(map[r][c] == 1) chz++;
            }
        }
        cnt = chz;

        while(chz > 0){
            time++;
            bfs();
            if(chz > 0){
                cnt = chz;
            }
        }
        sb.append(time).append("\n").append(cnt).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void bfs() {

        Queue<Point> q = new LinkedList<>();
        v = new boolean[N][M];
        q.offer(new Point(0, 0));
        v[0][0] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for(int d = 0; d < 4; d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(v[nx][ny]) continue;
                if (map[nx][ny] == 1) {
                    map[nx][ny] = 0;
                    v[nx][ny] = true;
                    chz--;
                }else{
                    v[nx][ny] = true;
                    q.offer(new Point(nx, ny));
                }
            }
        }

    }
}
