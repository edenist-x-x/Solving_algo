package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1493 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map;
    public static void main(String[] args) throws IOException {
        StringTokenizer st;

        input();
//        for(int i = 0; i < map.length; i++){
//            for(int j = 0; j < map[i].length; j++){
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int px = 0, py = 0;
            int qx = 0, qy = 0;

            for(int i = 0; i < map.length; i++){
                for(int j = 0; j < map[i].length; j++){
                    if (map[i][j] == p) {
                        px = i;
                        py = j;
                    }
                    if (map[i][j] == q) {
                        qx = i ;
                        qy = j ;
                    }
                }
            }
            int nx, ny;
            nx = px + qx;
            ny = py + qy;

            int res;
            res = map[nx][ny];
            System.out.println(res);

        }
    }
    public static void input(){
        map = new int[321][321];
        int idx = 1;
        for(int i = 1; i < 321; i++){
            for(int j = i;j > 0; j--){
                map[i - j + 1][j] = idx;
                idx++;
            }
        }
    }
}
