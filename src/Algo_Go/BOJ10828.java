package Algo_Go;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            String cmd = "";
            int X = 0;
            StringTokenizer st = new StringTokenizer(str);
            if (st.countTokens() > 1) {
                while (st.hasMoreTokens()) {
                    cmd = st.nextToken();
                    X = Integer.parseInt(st.nextToken());
                }
            } else {
                cmd = st.nextToken();
            }
            switch (cmd){
                case "push":
                    stack.push(X);
                    break;
                case "pop":
                    if (!stack.isEmpty()) {
                        sb.append(stack.pop()).append("\n");
                    } else{
                        sb.append(-1).append("\n");
                    }
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    if (stack.isEmpty()) {
                        sb.append(1).append("\n");
                    } else sb.append(0).append("\n");
                    break;
                case "top":
                    if (!stack.isEmpty()) {
                        sb.append(stack.peek()).append("\n");
                    } else sb.append(-1).append("\n");
                    break;

            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
