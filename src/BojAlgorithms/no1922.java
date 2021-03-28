package BojAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no1922 {
    static int N, M;
    static int[] parents;
    static Edge[] edgeLists;

    static class Edge implements Comparable<Edge>{
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    static void make(){
        for (int i = 0; i < N + 1; i++) {
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
        M = Integer.parseInt(br.readLine());

        parents = new int[N + 1];
        edgeLists = new Edge[M];

        for(int i = 0; i < M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edgeLists[i] = new Edge(from, to, weight);
        }
        Arrays.sort(edgeLists);

        make();

        int cnt = 0;
        int res = 0;

        for (Edge edge : edgeLists) {
            if (union(edge.from, edge.to)) {
                res += edge.weight;
                if(++cnt == N - 1) break;
            }
        }
        System.out.println(res);
    }
}
