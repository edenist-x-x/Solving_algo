package BojAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no16935 {
    static int N, M, R;
    static int[][] map;
    static int[] proc;

    static void first(){ // 상하 반전시키는 연산
        int temp = 0;
        for(int row = 0; row < N / 2; row++){ // 상하 반전이기에 행 / 2 만큼 반복을 하며 반전시키기 위함
            for(int col = 0; col < M; col++){
                temp = map[row][col]; // 임시 변수에 해당 배열의 값을 저장해두고 각 자리를 swap해준다.
                map[row][col] = map[N - row - 1][col];
                map[N - row - 1][col] = temp;
            }
        }
    }
    static void second(){
        int temp2 = 0;
        for(int row = 0; row < N; row++){
            for(int col = 0; col < M / 2; col++){   // 좌우 반전이기에 열 / 2만큼 반복을 하며 반전
                temp2 = map[row][col];  // 임시 변수에 해당 배열의 값을 저장해둔 후, 각 자리 swap
                map[row][col] = map[row][M - col - 1];
                map[row][M - col - 1] = temp2;
            }
        }
    }
    static void third(){    // 오른쪽으로 90도 회전하기 위한 함수.
        int[][] rotate = new int[map[0].length][map.length];
        for(int row = 0; row < map.length; row++){
            for(int col = 0; col < map[0].length; col++){
                rotate[col][map.length - 1 - row] = map[row][col];  // 행을 그대로 열로, 열을 행으로 이동시켜줌으로, 연산 후 대
            }
        }
        map = rotate;
    }
    static void fourth(){  // 왼쪽으로 90도 회전하기 위한 함수
        int[][] rotate1 = new int[map[0].length][map.length];
        for(int row = 0; row < rotate1.length; row++){
            for(int col = 0; col < rotate1[0].length; col++){
                rotate1[row][col] = map[col][rotate1.length - 1 - row];
            }
        }
        map = rotate1;
    }
    static void fifth(){ // 크기가 N/2×M/2인 4개의 부분 배열로 나누어서 각 그룹별 이동을 위한 함수
        int[][] res = new int[map.length][map[0].length];
        for(int row = 0; row < map.length / 2; row++){ // 1 -> 2
            for(int col = 0; col < map[0].length / 2; col++){
                res[row][col + map[0].length / 2] = map[row][col];
            }
        }
        for(int row = 0; row < map.length / 2; row++){ // 2 -> 3
            for(int col = map[0].length / 2 ; col < map[0].length; col++){
                res[row + map.length / 2][col] = map[row][col];
            }
        }
        for(int row = map.length / 2; row < map.length; row++){ // 3 -> 4
            for(int col = map[0].length / 2; col < map[0].length; col++){
                res[row][col - map[0].length / 2] = map[row][col];
            }
        }
        for(int row = map.length / 2; row < map.length; row++){ // 4 -> 1
            for(int col = 0; col < map[0].length / 2; col++){
                res[row - map.length / 2][col] = map[row][col];
            }
        }
        map = res;
    }
    static void sixth(){    // 크기가 N/2×M/2인 4개의 부분 배열로 나누어서 각 그룹별 이동을 위한 함수
        int[][] res1 = new int[map.length][map[0].length];

        for(int row = 0; row < map.length / 2; row++){ // 1 -> 4
            for(int col = 0; col < map[0].length / 2; col++){
                res1[row + map.length / 2][col] = map[row][col];
            }
        }
        for(int row = map.length / 2; row < map.length; row++){ // 4 -> 3
            for(int col = 0 ; col < map[0].length / 2; col++){
                res1[row][col + map[0].length / 2] = map[row][col];
            }
        }
        for(int row = map.length / 2; row < map.length; row++){ // 3 -> 2
            for(int col = map[0].length / 2; col < map[0].length; col++){
                res1[row - map.length / 2][col] = map[row][col];
            }
        }
        for(int row = 0; row < map.length / 2; row++){  // 2 -> 1
            for(int col = map[0].length / 2; col < map[0].length; col++){
                res1[row][col - map[0].length / 2] = map[row][col];
            }
        }
        map = res1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
//      각 변수 입력
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];    // 배열 map 선언 (크기가 N x M)
        for(int row = 0; row < N; row++){
            st = new StringTokenizer(br.readLine());
            for(int col = 0; col < M; col++){
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        proc = new int[R]; // 연산을 입력받을 배열 선언
        for(int i = 0; i < R; i++){
            proc[i] = Integer.parseInt(st.nextToken());

            switch (proc[i]) {  // 각 연산을 switch문으로 구분해서, 해당되는 함수를 호출.
                case 1:
                    first();
                    break;
                case 2:
                    second();
                    break;
                case 3:
                   third();
                    break;
                case 4:
                   fourth();
                    break;
                case 5:
                    fifth();
                    break;
                case 6:
                    sixth();
                    break;
            }
        }
        for(int i = 0; i < map.length; i++){    // 변경된 배열 출력
            for(int j = 0; j < map[0].length; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}
