/*
 *
 * BOJ_2751 수 정렬하기2
 * */
package BojAlgorithms;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class no2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] nums = new int[N];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            stack.add(nums[i]);
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append("\n");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
