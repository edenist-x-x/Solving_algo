package BojAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no2567 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[][] map = new int[101][101];
        int N = Integer.parseInt(st.nextToken());
        int tot = 0;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for(int row = b; row < b + 10; row++){
                for(int col = a; col < a + 10; col++){
                    map[row][col] = 1;
                }
            }
        }
        for(int i = 1; i <= 100; i++){
            for(int j = 1; j <= 100; j++){
                if (map[i][j] == 1) {
                    for(int d = 0; d < 4; d++){
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx >= 0 || nx < N || ny >= 0 || ny < N) {
                            if (map[nx][ny] == 0) {
                                tot++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(tot);
    }
}
