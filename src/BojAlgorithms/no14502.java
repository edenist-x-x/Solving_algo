package BojAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class no14502 {
    static int N, M;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int res = Integer.MIN_VALUE;
    static int zerocnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M]; // 입력받을 배열

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0);
        System.out.println(res);
    }

    static void dfs(int cnt) {
        if(cnt == 3){
            bfs();
            return;
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(cnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void bfs(){
        zerocnt = 0;
        Queue<Point> virus = new LinkedList<>();
        int[][] temp = new int[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                temp[i][j] = map[i][j];
                if(temp[i][j] == 2) virus.offer(new Point(i, j));
                if(temp[i][j] == 0) zerocnt++;
            }
        }

        while (!virus.isEmpty()) {
            Point cur = virus.poll();

            for(int d = 0; d < 4; d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if(!isIn(nx, ny)) continue;
                if(temp[nx][ny] == 0){
                    temp[nx][ny] = 2;
                    zerocnt--;
                    virus.offer(new Point(nx, ny));
                }
            }
        }
        res = Math.max(zerocnt, res);
    }

    static boolean isIn(int x, int y){
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    static class Point{
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
