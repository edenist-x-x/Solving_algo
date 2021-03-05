package BojAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no16926 {
    static int[] dx = {0, 1, 0, -1}; // 상, 하, 좌, 우
    static int[] dy = {1, 0, -1, 0}; // 상, 하, 좌, 우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for(int row = 0; row < N; row++){  // 배열 원소 입력
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < M; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }
        int group = Math.min(N, M) / 2;

        for(int i = 0; i < R; i++){
            for(int j = 0; j < group; j++){
                int x = j;
                int y = j;
                int tmp = map[x][y];
                int d = 0;
                while (d < 4) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nx >= j && nx < N - j && ny >= j && ny < M - j) {
                        map[x][y] = map[nx][ny];
                        x = nx;
                        y = ny;
                    }else d++;
                }
                map[j + 1][j] = tmp;

            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

}
