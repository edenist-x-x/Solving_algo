package Algo_Go;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/*
push X : 큐에 삽입
pop : 큐에서 가장 앞에 있는 정수 빼고, 그 수 출력. 없는 경우 -1 출력
size : 큐에 들어있는 정수의 개수 출력
empty : 큐가 비어있으면 1, 아니면 0
front : 큐의 가장 앞 정수 출력, 아무것도 없을 때 -1 출력
back : 큐의 가장 마지막 정수 출력, 아무것도 없을 때 -1 출력
*/
public class BOJ10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();

        int last = 0;

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            String cmd = "";
            int X = 0;
            StringTokenizer st = new StringTokenizer(str);
            cmd = st.nextToken();
            if (st.hasMoreTokens()) {
                X = Integer.parseInt(st.nextToken());
            }

            switch(cmd){
                case "push":
                    queue.offer(X);
                    last = X;
                    break;
                case "pop":
                    if (queue.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else sb.append(queue.poll()).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if (queue.isEmpty()) {
                        sb.append(1).append("\n");
                    } else sb.append(0).append("\n");
                    break;
                case "front":
                    if (queue.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else sb.append(queue.peek()).append("\n");
                    break;
                case "back":
                    if (queue.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else sb.append(last).append("\n");
                    break;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
