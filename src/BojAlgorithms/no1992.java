package BojAlgorithms;

import java.io.*;

public class no1992 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for(int row = 0; row < N; row++){
            String nums = br.readLine();
            for(int col = 0; col < N; col++){
                map[row][col] = nums.charAt(col) - '0';
            }
        }

        quadProc(0, 0, N);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean quadCheck(int x, int y, int n) { // 4분할을 해야하는지(배열 원소가 모두 0 또는 1인 같은수로 이루어져있는지) 판단하는 메서드
        int start = map[x][y]; // 시작점의 값을 기준으로
        for(int i = x; i < x + n; i++){
            for(int j = y; j < y + n; j++){ // 각 4분할 된 배열을 돌면서
                if (map[i][j] != start) {
                    return false;   // 시작점의 값 (0 또는 1)으로 배열이 전부 안이루어질 경우에는 false 반환
                }
            }
        }
        return true;    // 모두 같은 수로 4분할된 배열을 이루고 있으면 true 반환
    }

    static void quadProc(int row, int col, int n) { // quadCheck 메서드를 통해 모두 같은수일 경우 해당 수 반환, 그게아닐 경우 괄호열고 재귀 . 모든 과정이 끝나면 괄호를 닫아준다.
        if (!quadCheck(row, col, n)) {
            sb.append("(");
            int quadsize = n / 2;

//            4분할 된 배열 그룹을 순회
            for(int i = 0; i < 2; i++){
                for(int j = 0; j < 2; j++){
//                    재귀 실행, 배열의 시작 행, 열을 매개변수들 + 해당 인덱스 * 배열크기의 절반으로 주고
//                    배열 크기는 반으로 나눠줌.
                    quadProc(row + i * quadsize, col + j * quadsize, n / 2);
                }
            }
            sb.append(")");
        }
        else
            sb.append(map[row][col]);   // 모두 0 또는 1로 이루어진 그룹일 경우, 이를 이루고 있는 수 출력
    }
}
