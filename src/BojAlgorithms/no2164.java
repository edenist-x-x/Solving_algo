package BojAlgorithms;
/*
*
* BOJ 2164 카드 2
*
* */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class no2164 {
    static Queue<Integer> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        q = new LinkedList<>();

        for(int i = 1; i <= N; i++){
            q.offer(i);
        }
        dfs();


    }
    static void dfs(){
        if (q.size() == 1) {
            System.out.println(q.peek());
            return;
        }
        for(int i = 0; i < 2; i++){
            if (q.size() == 1) {
                break;
            }
            q.poll();
            q.offer(q.peek());
            q.poll();
        }
        dfs();
    }
}
