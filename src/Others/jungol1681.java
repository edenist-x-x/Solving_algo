package Others;

import java.util.Scanner;

public class jungol1681 {
    static int N;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;
    static int[][] map;

    public static void dfs(int start, int idx, int weight) {

        if ( weight >= min) {
            return;
        }

        if ( idx == N-1) {
            if ( map[start][0] !=0 ) {
                min = Math.min(min, weight + map[start][0]);
            }
            return;
        }
        for( int i=1; i<N; i++) {
            if ( map[start][i] != 0 && !visited[i]) {
                visited[i] = true;
                dfs(i, idx+1, map[start][i] + weight);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        dfs(0, 0, 0);

        System.out.println(min);
    }
}