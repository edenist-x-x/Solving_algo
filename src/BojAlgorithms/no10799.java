package BojAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class no10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            int res = 0;
            String str = br.readLine();
            String pipe = str.replace("()", "1");
            System.out.println(pipe);
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
            System.out.println(res);
        }
        br.close();
    }
}
