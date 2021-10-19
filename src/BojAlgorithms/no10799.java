package BojAlgorithms;

import java.io.*;
import java.util.Stack;

public class no10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int res = 0;
        String str = br.readLine();
        String pipe = str.replace("()", "1");
        Stack<Character> stack = new Stack<>();
        for(int i = 0;  i< pipe.length(); i++){
            char c = pipe.charAt(i);
            if(c == '('){
                stack.push(c);
            } else if (c == ')') {
                res += 1;
                stack.pop();
            } else if (c == '1') {
                res += stack.size();
            }
        }
        sb.append(res);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
