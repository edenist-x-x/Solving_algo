package BojAlgorithms;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class no12761 {
    static int A, B, N, M;
    static int[] dx = {-1, 1, -A, -B, A, B};
    static int[] map;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[100001];

        System.out.println(bfs());
    }
    static int bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        map[N] = 0;
        while (!q.isEmpty()) {
            int cx = q.poll();
            if (cx == M) {
                res = map[cx];
                break;
            }
            for(int d = 0; d < 6; d++){
                int nx = cx + dx[d];
                if(nx < 0 || nx >= 100000 || map[nx] == 0) continue;
                q.offer(nx);
                map[nx] = map[cx] + 1;
            }
            for(int d = 4; d < 6; d++){
                int nx = cx * dx[d];
                if(nx < 0 || nx >= 100000 || map[nx] == 0) continue;
                q.offer(nx);
                map[nx] = map[cx] + 1;
            }
        }
        return res;
    }
}
