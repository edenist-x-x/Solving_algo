package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class no1219 {
    static int N;
    static LinkNode[] graph;
    static int A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= 10; tc++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            N = Integer.parseInt(st.nextToken());

            graph = new LinkNode[N];

            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                graph[from] = new LinkNode(to, graph[from]);

            }
            // 입력처리가 끝나면 그래프를 꼭 비교해보기.
//            System.out.println(Arrays.toString(graph));
            A = 0;
//            bfs();
            dfs(0, new boolean[100]);
            sb.append("#").append(tc).append(" ").append(A).append("\n");

        }
        System.out.println(sb);
    }
    static void dfs(int no, boolean[] v){
        if (no == 99) {
            A = 1;
            return;
        }
        v[no] = true;

        LinkNode child = graph[no];
        while (child != null) {
            if (!v[child.i]) {
                dfs(child.i, v);
            }
            child = child.next;
        }
    }

    static void bfs(){
        Queue<Integer> q = new LinkedList<>();

        // 최대 100개, 도착점은 99.
        boolean[] v = new boolean[100];

        // 출발점은 0으로 고정.
        q.offer(0);
        v[0] = true;

        while (!q.isEmpty()) {
            int head = q.poll();

            if (head == 99) { // 도착 시
                A = 1;
                return;
            }
            LinkNode child = graph[head];
            while (child != null) { // child가 널이 아니고
                if (!v[child.i]) { // 아직 방문되지 않았다면
                    // 가보자 !
                    v[child.i] = true;
                    q.offer(child.i);
                }
                child = child.next;
            }
        }
    }

    static class LinkNode{
        int i; // 현재의 나
        LinkNode next; // 전에 가지는 값

        public LinkNode(int i, LinkNode next) {
            super();
            this.i = i;
            this.next = next;
        }

        @Override
        public String toString() {
            return "LinkNode{" +
                    "i=" + i +
                    ", next=" + next +
                    '}';
        }
    }
}
