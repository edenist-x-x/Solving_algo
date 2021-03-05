package BojAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class no15686 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[][] map;
    static boolean[][] v;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static class Point{
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        v = new boolean[N + 1][N + 1];
        for(int row = 1; row < N + 1; row++){
            st = new StringTokenizer(br.readLine());
            for(int col = 1; col < N + 1; col++){
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }
        int startx = 0;
        int starty = 0;
        for(int i = 1; i < N + 1; i++){
            for(int j = 1; j < N + 1; j++){
                if(map[i][j] == 1){ // 치킨집을 시작점으로.
                    startx = i;
                    starty = j;
                    bfs(startx, starty);
                }
            }
        }
    }

    private static void bfs(int x, int y) {
        Queue<Integer> q = new LinkedList<>();
        v[x][y] = true;
        q.offer(map[x][y]);

        while (!q.isEmpty()) {
            q.poll();

            for(int d = 0; d < 4; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && !v[nx][ny]) {
                    v[nx][ny] = true;
                    q.offer(map[nx][ny]);
                }
            }
        }

    }
}
