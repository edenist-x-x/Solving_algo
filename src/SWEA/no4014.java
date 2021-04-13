package SWEA;
/*
SWEA_4104 활주로 건설
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no4014 {
    static int N, X;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());

            map = new int[N][N];


            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println("#" + tc + " " + process());

        }
    }
    private static int process(){
        int cnt = 0;

        for(int i = 0; i < N; i++){
            if(makeRoadByRow(i)) cnt++;
            if(makeRoadByCol(i)) cnt++;
        }

        return cnt;
    }

    private static boolean makeRoadByRow(int i) {
        int beforeHeight = map[i][0]; // i행의 0열을 이전 높이로 설정
        int size = 0; // 연속된 동일높이
        int j = 0; // 열 탐색 위치
        while (j < N) {
            if (beforeHeight == map[i][j]) {
                size++;
                j++;
            } else if (beforeHeight + 1 == map[i][j]) { // 오르막 경사로 설치 가능한지 판단
                if (size < X) return false; // 경사로 설치 불가
                beforeHeight++;
                size = 1;
                j++;
            } else if (beforeHeight - 1 == map[i][j]) { // 내리막 경사로 설치 가능한지 판단
                int cnt = 0;

                for (int k = j; k < N; k++) {
                    if (map[i][k] != beforeHeight - 1) break;
                    if (++cnt == X) break;
                }
                if (cnt < X) return false; // 경사로 설치 불가
                beforeHeight--;
                size = 0;
                j += X;
            } else {
                return false;
            }
        }
        return true;
    }
    private static boolean makeRoadByCol(int i) {
        int beforeHeight = map[0][i]; // i행의 0열을 이전 높이로 설정
        int size = 0; // 연속된 동일높이
        int j = 0; // 열 탐색 위치
        while (j < N) {
            if (beforeHeight == map[j][i]) {
                size++;
                j++;
            } else if (beforeHeight + 1 == map[j][i]) { // 오르막 경사로 설치 가능한지 판단
                if (size < X) return false; // 경사로 설치 불가
                beforeHeight++;
                size = 1;
                j++;
            } else if (beforeHeight - 1 == map[j][i]) { // 내리막 경사로 설치 가능한지 판단
                int cnt = 0;

                for (int k = j; k < N; k++) {
                    if (map[k][i] != beforeHeight - 1) break;
                    if (++cnt == X) break;
                }
                if (cnt < X) return false; // 경사로 설치 불가
                beforeHeight--;
                size = 0;
                j += X;
            } else {
                return false;
            }
        }
        return true;
    }


}
