package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class no7793 {

        static int N, M;
        static char[][] map;
        static Queue<Point> p;
        static int A;
        static int[][] deltas = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            p = new LinkedList<Point>();
            map = new char[N][];
            Point sPoint = null; // 수연이의 좌표를 미리 할당.

            for(int i = 0; i < N; i++){
                map[i] = br.readLine().toCharArray();
                for(int j = 0; j < M; j++){
                    if (map[i][j] == '*') {
                        p.offer(new Point(i, j, true));
                    } else if (map[i][j] == 'S') {
                        sPoint = new Point(i, j, false);
                    }
                }
            } // 지도 읽기
            // 수연이는 모든 악마가 다 들어간 다음 동작하자.
            p.offer(sPoint);
//            System.out.println(p);
            A = Integer.MAX_VALUE;
            bfs();
            //여전히 A가 MAX_VALUE 이면 여신을 못만난 것.
            sb.append("#").append(tc).append(" ").append(A == Integer.MAX_VALUE ? "GAME OVER" : A).append("\n");
        }
        System.out.println(sb);

    }
    static void bfs(){
        int turn = 1; // depth
        while (!p.isEmpty()) {
            // 초마다 현재 queue 사용하기..
            int size = p.size();
            while (size-- > 0) {
                Point head = p.poll();

                // 자식 탐색 (사방 탐색)
                for(int d = 0; d < deltas.length; d++){
                    int nx = head.n + deltas[d][0];
                    int ny = head.m + deltas[d][1];

                    if (isIn(nx, ny)) {
                        if (head.isDevil) { // 지금 인덱스 녀석이 악마일 경우 다음 갈수있는 곳 : . 또는 S
                            if (map[nx][ny] == '.' || map[nx][ny] == 'S') {
                                map[nx][ny] = '*'; // 이렇게 해주면 방문처리가 된다. 따로 안해줘도 됌.
                                p.offer(new Point(nx, ny, true)); // 새로운 좌표가 악마가 되어 이동.
                            }
                        }else{
                            if (map[nx][ny] == 'D') { // 여신을 만날경우 게임 종료.
                                A = turn; // 현재까지 턴 수를 넘겨주고 끗
                                return;
                            }else if(map[nx][ny] == '.'){ // 갈 수 있는 곳.
                                map[nx][ny] = 'S';
                                p.offer(new Point(nx, ny, false));

                            }
                        }
                    }
                }

            }
            turn++;
        }
    }
    static boolean isIn(int x, int y){
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    static class Point{
        int n, m;
        boolean isDevil;

        public Point(int n, int m, boolean isDevil) {
            this.n = n;
            this.m = m;
            this.isDevil = isDevil;


        }

        @Override
        public String toString() {
            return "Point{" +
                    "n=" + n +
                    ", m=" + m +
                    ", isDevil=" + isDevil +
                    '}';
        }


    }
}
