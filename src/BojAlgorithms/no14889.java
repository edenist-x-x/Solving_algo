package BojAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class no14889 {
    static int N;
    static int[][] map;
    static int min = Integer.MAX_VALUE;
    static ArrayList<Integer> lista = new ArrayList<>();;
    static ArrayList<Integer> listb = new ArrayList<>();;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        StringTokenizer st;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        for(int i = 0; i < N; i++){
//            for(int j = 0; j < N; j++){
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }


        dfs(0);
        System.out.println(min);

    }

    static void dfs (int idx) {
        if(lista.size() > N/2 || listb.size() > N/2) return;

        if (idx == N) {
            if (lista.size() == N / 2 && listb.size() == N / 2) {
                getMin();
            }
            return;
        }
        lista.add(idx);
        dfs(idx + 1);
        lista.remove(lista.size() - 1);

        listb.add(idx);
        dfs(idx + 1);
        listb.remove(listb.size() - 1);


    }

    static void getMin(){
        int a = 0, b = 0;

        for(int i = 0; i < N / 2; i++){
            for(int j = 0; j < N / 2; j++){
                if (i != j) {
                    a += map[lista.get(i)][lista.get(j)];
                    b += map[listb.get(i)][listb.get(j)];
                }
            }
        }
        min = Math.min(min, Math.abs(a - b));
    }
}
