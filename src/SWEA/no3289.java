package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no3289 {
    static int n;
    static int[] p;

    static void make(){
        for(int i = 0; i < p.length; i++){
            p[i] = i;
        }
    }

    static int findSet(int a){
        if(a == p[a]) return a;
        return p[a] = findSet(p[a]);
    }

    static void union(int a, int b){
        a = findSet(a);
        b = findSet(b);
        if(a > b)
            p[a] = b;
        else
            p[b] = a;
    }

    public static boolean find(int a, int b) {
        return (findSet(a) == findSet(b));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            p = new int[n + 1];
            make();

            System.out.print("#" + tc + " ");
            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int pa = Integer.parseInt(st.nextToken());
                int pb = Integer.parseInt(st.nextToken());
                int pc = Integer.parseInt(st.nextToken());

                if (pa == 1) {
                    if (find(pb, pc)) {
                        System.out.print(1);
                    }
                    else System.out.print(0);
                }else{
                    union(pb, pc);
                }
            }
            System.out.println();

        }
    }

}
