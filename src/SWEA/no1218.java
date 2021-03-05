package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class no1218 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        char[] word = null;
        char temp;
        for(int tc = 1; tc <= 10; tc++){
            int[] res = new int[11];
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            word = str.toCharArray();
            for(int i = 0; i < n; i++){
                if (word[i] == '(' || word[i] == '[' || word[i] == '{' || word[i] == '<') {
                    stack.push(word[i]);
                }
                else{
                    temp = stack.peek();
                    if (temp == '(' && word[i] == ')') {
                        stack.pop();
                    } else if (temp == '[' && word[i] == ']') {
                        stack.pop();
                    }else if (temp == '{' && word[i] == '}') {
                        stack.pop();
                    }else if (temp == '<' && word[i] == '>') {
                        stack.pop();
                    }else
                        break;
                }
            }
            if (stack.isEmpty()) {
                res[tc] = 1;
            }
            else
                res[tc] = 0;

            System.out.println("#" + tc + " " + res[tc]);
            stack.clear();
        }
    }
}
