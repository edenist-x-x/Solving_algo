package Others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class algo12 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int R, C;
    static char[][] map;
    static int[] dx = {-1, 0, 1};
    static int[] dy = {1, 1, 1};
    static char[][] v;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for(int row = 0; row < R; row++){
            String input = br.readLine();
            for(int col = 0; col < C; col++){
                map[row][col] = input.charAt(col);
            }
        }
        int cnt = 0;
        v = new char[R][C];
        for(int col = 0; col < C; col++){
            for(int row = 0; row < R; row++){
                if (map[col][row] != 'x') {
                    dfs(col, row);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
    static void dfs(int x, int y){
        map[x][y] = 'x';

        for(int d = 0; d < 3; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= R || ny >= C - 1) continue;
            if(map[nx][ny] == 'x') continue;
            dfs(nx, ny);
        }
    }
}
