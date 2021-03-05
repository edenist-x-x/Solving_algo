package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1220 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int tc = 1; tc <= 10; tc++){
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            for(int row = 0; row < N; row++){
                String str = br.readLine();
                st = new StringTokenizer(str, " ");
                for(int col = 0; col < N; col++){
                    map[row][col] = Integer.parseInt(st.nextToken());
                }
            }
            int cnt = 0;
            for(int col = 0; col < N; col++){
                boolean v = false;
                for(int row = 0; row < N; row++){
                    if (map[row][col] == 0) continue;
                    if(map[row][col] != 1){
                        if (v) {
                            cnt++;
                            v =  false;
                        }
                    }
                    else
                        v = true;
                }
            }
            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
