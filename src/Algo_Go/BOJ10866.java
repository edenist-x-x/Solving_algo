package Algo_Go;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            String cmd = "";
            int X = 0;
            StringTokenizer st = new StringTokenizer(str);
            cmd = st.nextToken();
            if (st.hasMoreTokens()) {
                X = Integer.parseInt(st.nextToken());
            }
            switch (cmd){
                case "push_front":
                    dq.addFirst(X);
                    break;
                case "push_back":
                    dq.addLast(X);
                    break;
                case "pop_front":
                    if (dq.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else sb.append(dq.pollFirst()).append("\n");
                    break;
                case "pop_back":
                    if (dq.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else sb.append(dq.pollLast()).append("\n");
                    break;
                case "size":
                    sb.append(dq.size()).append("\n");
                    break;
                case "empty":
                    if(dq.isEmpty()){
                        sb.append(1).append("\n");
                    }
                    else sb.append(0).append("\n");
                    break;
                case "front":
                    if (dq.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else sb.append(dq.peekFirst()).append("\n");
                    break;
                case "back":
                    if (dq.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else sb.append(dq.peekLast()).append("\n");
                    break;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
