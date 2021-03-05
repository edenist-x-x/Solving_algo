package SWEA;

import java.util.Scanner;

public class no1210 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 0;
        int y = 0;
        int[] dx = {0, 0, -1};
        int[] dy = {-1, 1, 0};


        for(int tc = 1; tc <=10; tc++){
            int t = sc.nextInt();
            int[][] map = new int[100][100];

            for(int i = 0; i < map.length; i++){
                for(int j = 0; j < map[i].length; j++){
                    map[i][j] = sc.nextInt();
                    if(map[i][j] == 2){
                        x = i;
                        y = j;
                    }
                }
            }
            boolean onway = false;
            while(!onway){
                if(x == 0){
                    onway = true;
                }
                for(int i = 0; i < 3; i++){
                    if (x + dx[i] >= 0 && y + dy[i] < 100 && y + dy[i] >= 0 && map[x + dx[i]][y+dy[i]] == 1) {
                        map[x][y] = 0;
                        x += dx[i];
                        y += dy[i];
                        break;
                    }
                }
            }
            int result = y;


            System.out.println("#" + tc + " " + result);


//            for(int i = 0; i < 100; i++){
//                for(int j = 0; j < 100; j++){
//                    System.out.print(map[i][j]);
//                }
//                System.out.println();
//            }
        }
    }
}
