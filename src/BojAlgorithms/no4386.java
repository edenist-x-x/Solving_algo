package BojAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class no4386 {
    static int N;
    static int[] parents;
    static ArrayList<Edge> edgeLists;

    static class Point{
        double x, y;
        int no;

        public Point(double x, double y, int no) {
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
            if (this.weight < o.weight) {
                return -1;
            }
            return 1;
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

        N = Integer.parseInt(br.readLine());

        parents = new int[N + 1];
        Point[] points = new Point[N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            points[i] = new Point(x, y, i);
        }
        edgeLists = new ArrayList<>();

        for(int i = 0; i < N; i++){
            for(int j = i + 1; j < N; j++){
                double weight = Math.sqrt(Math.pow(points[i].x - points[j].x, 2) + Math.pow(points[i].y - points[j].y, 2));

                edgeLists.add(new Edge(points[i].no, points[j].no, weight));
            }
        }
//        Arrays.sort(edgeLists);
        Collections.sort(edgeLists);

        make();

        int cnt = 0;
        double res = 0;

//        for (Edge edge : edgeLists) {
//            if (union(edge.from, edge.to)) {
//                res += edge.weight;
//                if(++cnt == N - 1) break;
//            }
//        }
        for(int i = 0; i < edgeLists.size(); i++){
            Edge edge = edgeLists.get(i);

            if (union(edge.from, edge.to)) {
                res += edge.weight;
                if(++cnt == N - 1) break;
            }
        }
        System.out.println(res);
    }
}
