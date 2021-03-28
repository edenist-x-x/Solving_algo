package SWEA;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class no1251 {
    static int N;
    static int[][] map;
    static int[] parents;
    static ArrayList<Edge> edgeList;
    static class Point{
        int x, y, no;

        public Point(int x, int y, int no) {
            this.x = x;
            this.y = y;
            this.no = no;
        }
    }

    static class Edge implements Comparable<Edge>{
        int from, to;
        double weight;

        public Edge(int from, int to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.weight, o.weight);
        }
    }

    static void make(){
        for(int i = 0; i < N; i++){
            parents[i] = i;
        }
    }

    static int findSet(int a){
        if(parents[a] == a) return a;
        return parents[a] = findSet(parents[a]);
    }

    static boolean union(int a, int b){
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if(aRoot == bRoot) return false;

        parents[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){

            sb.append("#").append(tc).append(" ");

            N = Integer.parseInt(br.readLine());
            parents = new int[N + 1];

            map = new int[N][2];
            Point[] points = new Point[N];
            StringTokenizer sx = new StringTokenizer(br.readLine());
            StringTokenizer sy = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++){
                map[i][0] = Integer.parseInt(sx.nextToken());
                map[i][1] = Integer.parseInt(sy.nextToken());

                points[i] = new Point(map[i][0], map[i][1], i);
            }
            double E = Double.parseDouble(br.readLine());

            edgeList = new ArrayList<>();

            for(int i = 0; i < N; i++){
                for(int j = i + 1; j < N; j++){
                    double temp = Math.sqrt(Math.pow(points[i].x - points[j].x, 2) + Math.pow(points[i].y - points[j].y, 2));
                    double weight = Math.pow(temp, 2) * E;
                    edgeList.add(new Edge(points[i].no, points[j].no, weight));
                }
            }
            make();
            Collections.sort(edgeList);

            int cnt = 0;
            double res = 0;

            for(int i = 0; i < edgeList.size(); i++){
                Edge edge = edgeList.get(i);

                if (union(edge.from, edge.to)) {
                    res += edge.weight;
                    if(++cnt == N - 1) break;
                }
            }
            sb.append(Math.round(res)).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
