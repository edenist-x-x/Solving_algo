package BojAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1922_prim {
    static int N, M;
    static int[][] adjMatrix;
    static boolean[] visited;
    static int[] minEdge;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        adjMatrix = new int[N][N];
        visited = new boolean[N];
        minEdge = new int[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
            minEdge[i] = Integer.MAX_VALUE;
        }
        int res = 0;
        minEdge[0] = 0;

        for(int i = 0; i < N; i++){
            int min = Integer.MAX_VALUE;
            int minVertex = 0;

            for(int j = 0; j < N; j++){
                if (!visited[j] && min > minEdge[j]) {
                    min = minEdge[j];
                    minVertex = j;
                }
            }

            res += min;
            visited[minVertex] = true;

            for(int j = 0; j < N; j++){
                if (!visited[j] && adjMatrix[minVertex][j] != 0 && minEdge[j] > adjMatrix[minVertex][j]) {
                    minEdge[j] = adjMatrix[minVertex][j];
                }
            }
        }
        System.out.println(res);
    }
}
