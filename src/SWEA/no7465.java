package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no7465 {
    static int N, M;
    static int[] p;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            res = 0;
            makeSet();

            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
//                System.out.println(Arrays.toString(p));
            }

            System.out.println(Arrays.toString(p));
            for(int i = 1; i <= N; i++){
                if (p[i] == i) {
                    res++;
                }
            }
//            System.out.println(Arrays.toString(p));

            System.out.println("#" + tc + " " + res );
        }
    }
    static void makeSet(){
        p = new int[N + 1];
        for(int i = 1; i < N + 1; i++){
            p[i] = i;
        }
    }

    static int findSet(int a){
        if(p[a] == a) return a;

        return p[a] = findSet(p[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if(aRoot == bRoot) return false;
        p[bRoot] = aRoot;
        return true;
    }
}
