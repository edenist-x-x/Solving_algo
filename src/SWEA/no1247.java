package SWEA;

import java.io.*;
import java.util.StringTokenizer;

public class no1247 {
    static int N, min;
    static boolean[] v;
    static Point[] customer;
    static Point home, company;
    static int[] cus;

    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            N = Integer.parseInt(br.readLine());
            min = Integer.MAX_VALUE;

            customer = new Point[N];
            cus = new int[N];
            v = new boolean[N];
            st = new StringTokenizer(br.readLine());

            home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            company = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            for(int i = 0; i < N; i++){
                customer[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            permutation(0);
            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

     static void permutation(int cnt) {
        if (cnt == N) {
//            int tot = Math.abs(company.x - customer[cus[0]].x) + Math.abs(company.y - customer[cus[0]].y);
//            for(int i = 0; i < N - 1; i++){
//                tot += Math.abs(customer[cus[i]].x - customer[cus[i + 1]].x) + Math.abs(customer[cus[i]].y - customer[cus[i + 1]].y);
//            }
//            tot += Math.abs(customer[cus[N - 1]].x - home.x) + Math.abs(customer[cus[N - 1]].y - home.y);
//            min = Math.min(min, tot);
            searchLocation();
            return;
        }
        for(int i = 0; i < N; i++){
            if(v[i]) continue;
            v[i] = true;
            cus[cnt] = i;
            permutation(cnt + 1);
            v[i] = false;
        }
    }
    static void searchLocation(){
        int tot = Math.abs(company.x - customer[cus[0]].x) + Math.abs(company.y - customer[cus[0]].y);
        for(int i = 0; i < N - 1; i++){
            tot += Math.abs(customer[cus[i]].x - customer[cus[i + 1]].x) + Math.abs(customer[cus[i]].y - customer[cus[i + 1]].y);
        }
        tot += Math.abs(customer[cus[N - 1]].x - home.x) + Math.abs(customer[cus[N - 1]].y - home.y);
        min = Math.min(min, tot);
    }
}
