package BojAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no2615 {
    static int[] dx = {-1, 0, 1, 1};
    static int[] dy = {1, 1, 1, 0};
    static int[][] map;
    static int res = 0;
    static int resx = 0, resy = 0;

    public static void main(String[] args) throws IOException {
        map = new int[20][20];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int row = 1; row <= 19; row++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int col = 1; col <= 19; col++){
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }
        for(int row = 1; row <= 19; row++){
            for(int col = 1; col <= 19; col++){
                if(map[row][col] == 1 || map[row][col] == 2)
                    omok(row, col);
                if (res != 0) {
                    System.out.println(res);
                    System.out.println(resx+ " " + resy);
                    return;
                }
            }
        }
        System.out.println(res);
    }

    static void omok(int x, int y){
        for(int d = 0; d < 4; d++){
            int nx = x;
            int ny = y;
            boolean flag = true;
            for(int dd = 0; dd < 5; dd++){
                if(nx < 1 || ny < 1 || nx > 19 || ny > 19 || (map[x][y] != map[nx][ny])) {
                    flag = false;
                    break;
                }
                nx += dx[d];
                ny += dy[d];
            }
            if(flag == true){
                if((nx < 1 || ny < 1 || nx > 19 || ny > 19 || map[x][y] != map[nx][ny])
                        && (x - dx[d] < 1 || y - dy[d] < 1 || x - dx[d] > 19 || y - dy[d] > 19 ||
                        map[x][y] != map[x - dx[d]][y - dy[d]])){
                    res = map[x][y];
                    resx = x ;
                    resy = y ;
                }
            }

        }
    }

}