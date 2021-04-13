package BojAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no1197_kruskal {
    static int V, E;
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
        for(int i = 0; i <= V; i++){
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
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parents = new int[V + 1];
        edgeLists = new Edge[E];

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edgeLists[i] = new Edge(from, to, weight);
        }

        Arrays.sort(edgeLists);
        make();

        int cnt = 0;
        int sum = 0;

        for (Edge edge : edgeLists) {
            if(union(edge.from, edge.to)){
               sum += edge.weight;
               if(++cnt == V - 1) break;
            }
        }

        System.out.println(sum);
    }
}
