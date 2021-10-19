package BojAlgorithms;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class no17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
            stack.push(nums[i]);
        }
        while (!stack.isEmpty()) {
            
        }
    }
}
