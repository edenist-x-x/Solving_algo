package BojAlgorithms;
/*
*
* BOJ_1987 알파벳
* -- 1행 1열의 말이 중복된 알파벳 없이 4방향으로 이동할 수 있는 최대 칸 수를 출력하는 프로그램
*
* -- 접근법
*
*   1. dfs로 탐색을 하자.
*   2. 1행 1열 즉 (0, 0)부터 탐색하면서 해당 좌표의 값을 배열리스트에 넣고
*   3. 재귀실행 및 호출을 하면서 .contains를 이용해 이미 지나온 알파벳인지 판별 등 가지치기
*   4. 탐색이 끝난 후 경로 수의 최대값을 구해서 출력하자.
*
* */
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class no1987 {
//     delta 좌, 우, 상, 하
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int R, C;
    static char[][] map;
    static boolean[][] v;
    static ArrayList<Character> saved = new ArrayList<>();
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        v = new boolean[R][C];  // 방문체크용 배열
        max = Integer.MIN_VALUE;    // 최대값 변수
        for(int row = 0; row < R; row++){   // 배열 원소 입력
            String str = br.readLine();
            for(int col = 0; col < C; col++){
                map[row][col] = str.charAt(col);
            }
        }
        saved = new ArrayList<>();  // 방문한 알파벳을 저장하는 어레이리스트 생성

        dfs(0, 0, 1);   // 재귀 호출
        sb.append(max); // 최대값을 담아주고
        bw.write(sb.toString());    // 출력
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int x, int y, int cnt) {    // 매개변수, 현재 좌표와 경로 카운트하는 변수로 둠.

        saved.add(map[x][y]);   // 배열리스트에 판별하려는 좌표의 알파벳을 넣어준다.
        v[x][y] = true; // 방문했으니 true
        max = Math.max(cnt, max);   // 경로수의 최대값을 구한다.
        for(int d = 0; d < 4; d++){ // 4방탐색
            int nx = x + dx[d];
            int ny = y + dy[d];

//            가지치기
            if(nx < 0 || nx >= R || ny < 0 || ny >= C) continue;    // 4방 범위에서 벗어나면 넘긴다.
            if(saved.contains(map[nx][ny])) continue;   // 만약 다음 좌표의 값이 이미 방문했던 알파벳이라면 넘긴다.
            if(v[nx][ny]) continue; // 좌표가 방문했던 곳이면 넘기기
            v[nx][ny] = true;   // 가지치기가 끝난 후, 조건에 부합하면 다음 좌표 방문처리

            dfs(nx, ny, cnt + 1); // 재귀
        }
//        여기서 해결하기까지 시간이 많이걸렸습니다. 만약 탐색도중 더이상 이동할 곳이 없어지게 되고
//        다음 좌표에서 탐색을 해야할 때, 기존의 방문했던 곳의 알파벳을 저장한 어레이리스트에 그대로 알파벳들이 남아있어서
//        최대경로라 하더라도 배열리스트에 남아있는 알파벳을 제외해서 오답이 나왔었습니다.
        saved.remove(saved.size() - 1);
        v[x][y] = false;
    }
}
