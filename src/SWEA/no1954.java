package SWEA;

import java.util.Scanner;

public class no1954 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int T = sc.nextInt();

        for(int tc = 1; tc <= T; tc++){
            int n = sc.nextInt();
            int[][] arr = new int[n][n];

            if(n == 1){
                System.out.println("#" + tc);
                System.out.println("1");
                continue;
            }

            int x = 0;
            int y = 0;
            int path = 0;

            for(int i = 0; i < n * n; i++){
                arr[x][y] = i + 1;
                x += dx[path];
                y += dy[path];

                if(x >= n || y >= n || x < 0 || y < 0){
                    x -= dx[path];
                    y -= dy[path];
                    path = (path + 1) % 4;

                    x += dx[path];
                    y += dy[path];
                }

                if(arr[x][y] != 0){
                    x -= dx[path];
                    y -= dy[path];
                    path = (path+1)%4;
                    x += dx[path];
                    y += dy[path];
                }
            }
            System.out.println("#" + tc);
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
