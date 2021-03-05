package BojAlgorithms;

import java.io.*;
import java.util.StringTokenizer;

public class no4963 {
    static int w, h;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb;
    static int[][] map;
    static int[][] v;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int res;

    public static void main(String[] args) throws IOException {
        while(true){
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) {
                bw.close();
                br.close();
                return;
            }
            map = new int[h][w];
            v = new int[h][w];
            for(int row = 0; row < map.length; row++){
                st = new StringTokenizer(br.readLine());
                for(int col = 0; col < map[0].length; col++){
                    map[row][col] = Integer.parseInt(st.nextToken());
                }
            }
            res = 0;
            for(int row = 0; row < map.length; row++){
                for(int col = 0; col < map[0].length; col++){
                    if (map[row][col] == 1) {
                        dfs(row, col);  // 시작점으로부터 탐색 시작
                        res++;
                    }
                }
            }
            sb = new StringBuilder();
            sb.append(res);
            bw.write(sb.toString());
            bw.newLine();
            bw.flush();


//      입출력 확인
//            for(int i = 0; i < map.length; i++){
//                for(int j = 0; j < map[0].length; j++){
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();

        }

    }
    static void dfs(int x, int y){
        map[x][y] = 0; // 방문처리

        for(int d = 0; d < 8; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
            if(map[nx][ny] == 0) continue;
            dfs(nx, ny);
        }
    }
}
