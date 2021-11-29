package OnlineCoding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
빈곳 ->   '.'
벽 ->    '#'
열쇠 ->   'a ~ f'
문 ->    'A ~ F'
민식이 현재 위치 -> '0'
출구 ->   '1'
 */

public class no1194 {
    static int N, M;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Point start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = str.charAt(j);
                if (map[i][j] == '0') { // 시작위치 판단.
                    start = new Point(j, i, 0, 0); // 아무 키도 안갖고 있으니, 000000 = no key.
                }
            }
        }

        System.out.println(bfs());

//        for(int i = 0; i < N; i++){
//            for(int j = 0; j < M; j++){
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }
    }

    private static int bfs() {
        Queue<Point> q = new LinkedList<>();
//        방문 체크 배열
//        키를 가지고 지나가는 경우, 안가지고 지나가는 경우도 판별해야 하기때문에 3차원배열.
//        비트연산자를 통해서 지정횟수만큼 이동하게되면 .
        boolean[][][] v = new boolean[N][M][1 << 6]; // 2의 6승값의 개수.

//        큐의 첫번째 삽입
        q.offer(start);
//        방문 체크
        v[start.y][start.x][start.key] = true;
        while(!q.isEmpty()){
            Point cur = q.poll();
            if (map[cur.y][cur.x] == '1') { // 가장 빨리 출구를 찾으면 거기서 아웃. (bfs)를 더이상 반복할 필요가 없어짐.
                return cur.cnt; // 현재의 cnt를 반환하며 걍 바로 빠져나옴.
            }

            for(int d = 0; d < 4; d++){
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                int nkey = cur.key; // 새로운 키.

//                범위체크
                if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
//                벽 체크
                if(map[ny][nx] == '#') continue;
//                key 이면 줍고
                if ('a' <= map[ny][nx] && map[ny][nx] <= 'f') { // 비트마스킹 추가  |
                    nkey = nkey | (1 << map[ny][nx] - 'a'); // 'a'=> 97 / a면 그자리 0 , b면 => 98 그자리 1
//                    즉 보정해주는거, 문자를 숫자화 시키는 것.
                }
//                문이면 key 체크
                if ('A' <= map[ny][nx] && map[ny][nx] <= 'F') { // 비트마스킹 검사  &
                    if ((nkey & (1 << map[ny][nx] - 'A')) == 0) { // 문인데 key가 없으면, 011101 (현재의 key 상태) & 000010 (예시, b라는 문) ==> 0
                                                                  // 우측의 자리값과 비교해서 왼쪽에 있으면, 해당되는 것 나오고 없으면 0
                        continue;
                    }
                }
//                방문 체크
                if(v[ny][nx][nkey]) continue;
//                그렇지 않으면 큐에 삽입.
                q.offer(new Point(nx, ny, cur.cnt + 1, nkey));
                v[ny][nx][nkey] = true;
            }
        }
        return -1; // 출구를 다 돌때까지 만나지 못하면 -1 리턴.
    }
    static class Point{ // bfs 시에 내가 받게되는 변수가 있다면 이런식으로.
        int x, y, cnt;

        int key; // fedcba      010101 ==> 21 비트마스킹으로 int처리해주는.. ?
                 // 000000 ~ 111111 -> 하나도 갖고있지 않을 때 / 모두 갖고 있을 때

        public Point(int x, int y, int cnt, int key) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.key = key;
        }
    }
}
