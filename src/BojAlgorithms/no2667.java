package BojAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class no2667 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;
    static int [][]map;
    static boolean[][] v;
    static int cnt = 0;
    static ArrayList<Integer> list = new ArrayList<>();
    static int houseCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        v = new boolean[N][N];


        for(int i = 0; i < N; i++){
            String ipt = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = ipt.charAt(j) - '0';
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 1 && !v[i][j]){
                    houseCnt = 0;
                    cnt++; // 단지번호 증가
                    dfs(i, j);
                    list.add(houseCnt);
                }
            }
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println(cnt);
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

    }

    static void dfs(int x, int y) {
        v[x][y] = true;
        houseCnt++;

        for(int d = 0; d < 4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if(map[nx][ny] != 1) continue;
            if(v[nx][ny]) continue;
            dfs(nx , ny);
        }
    }
}
