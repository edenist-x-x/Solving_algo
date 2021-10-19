package BojAlgorithms;

import java.io.*;
import java.util.StringTokenizer;

public class no1956 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int INF = 999999999;


        int[][] map = new int[V + 1][V + 1];

        for(int i = 1; i <= V; i++){
            for(int j = 1; j <= V; j++){
                    map[i][j] = INF;
            }
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[a][b] = c;
        }

        for(int k = 1; k <= V; k++){
            for(int i = 1; i <= V; i++){
                for(int j = 1; j <= V; j++){
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                        }
                    }
                }
            }

            int min = INF;
            for(int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if (map[i][j] == INF || map[j][i] == INF) continue;
                    else {
                        min = Math.min(min, map[i][j] + map[j][i]);
                    }
                }
            }
            if(min == INF) sb.append(-1);
            else sb.append(min);

            bw.write(sb.toString());
            bw.flush();
            bw.close();
            br.close();
    }
}
