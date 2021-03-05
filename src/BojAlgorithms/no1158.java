package BojAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
*
* BOJ 1158 요세푸스 문제
*
* */
public class no1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String tc = br.readLine();
        st = new StringTokenizer(tc, " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < N; i++){
            q.offer(i + 1);
        }

        sb.append("<");
        while(q.size() > 1) {
            for (int i = 0; i < K; i++) {
                if (i == K - 1) {
                    sb.append(q.poll() + ", ");
                } else
                    q.offer(q.poll());
            }
        }
        sb.append(q.poll());
        sb.append(">");
        System.out.println(sb);
//        System.out.println(Arrays.toString(nums));
        br.close();
    }

}
