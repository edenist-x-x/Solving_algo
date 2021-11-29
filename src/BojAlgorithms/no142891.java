package BojAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
N극 : 0
S극 : 1
시계방향 : 1
반시계방향 : -1
* */

public class no142891 {
    static int[][] arr;
    static int[] dirArr;
    static int score;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        arr = new int[5][9];
        for(int i = 1; i <= 4; i ++){
            String str = br.readLine();
            for(int j = 0; j < 8; j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        int K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            dirArr = new int[5];
            dirArr[idx] = dir;

            findLeft(idx - 1, dir * -1);
            findRight(idx + 1, dir * -1);

            rotate();
        }
        int point = 1;
        for(int i = 1; i <= 4; i++){
            if (arr[i][0] == 1) {
                score += point;
            }
            point *= 2;
        }
        System.out.println(score);
    }

    static void findRight(int idx, int dir){
        if(idx == 5) return; // 톱니 인덱스 범위 체크

        if (arr[idx - 1][2] != arr[idx][6]) { // 중간 만나는 지점이 같지않을 경우 계속 돌아야하니까 재귀
            dirArr[idx] = dir; // 기준점 업데이트
            findRight(idx + 1, dir * -1);
        }
    }

    static void findLeft(int idx, int dir){
        if(idx == 0) return;

        if (arr[idx][2] != arr[idx + 1][6]) {
            dirArr[idx] = dir;
            findLeft(idx - 1, dir * -1);
        }
    }
    static void rotate() {
        for(int i = 1; i <= 4; i++){
            // 반시계
            if(dirArr[i] == -1){
                int first = arr[i][0];
                for(int j = 1; j < 8; j++){
                    arr[i][j - 1] = arr[i][j];
                }
                arr[i][7] = first;
            }
            // 시계
            else if (dirArr[i] == 1) {
                int last = arr[i][7];
                for(int j = 6; j >= 0; j--){
                    arr[i][j + 1] = arr[i][j];
                }
                arr[i][0] = last;
            }
        }
    }
}
