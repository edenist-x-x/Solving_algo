package SWEA;

import java.util.Scanner;

/*
*
* 파리 퇴치
*
* */
public class no2001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] map = new int[N][N];

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    map[i][j] = sc.nextInt();
                }
            }
            int res = 0;
            for(int i = 0; i < N - M + 1; i++){
                for(int j = 0; j < N - M + 1; j++){
                    int sum = 0;
                    for(int m = 0; m <  M; m++){
                        for(int n = 0; n <  M; n++){
                            sum += map[i + m][j + n];
                        }
                    }
                    if(res < sum){
                        res = sum;
                    }
                }
            }
            System.out.println("#" + tc + " " +  res);


//            for(int i = 0; i < N; i++){
//                for(int j = 0; j < N; j++){
//                    System.out.print(map[i][j]);
//                }
//                System.out.println();
//            }

        }
    }
}
