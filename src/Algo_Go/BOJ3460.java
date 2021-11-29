package Algo_Go;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

// 13 -> 1 1 0 1
public class BOJ3460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());

            Stack<Integer> stack = new Stack<>();
            ArrayList<Integer> list = new ArrayList<>();

            String b = Integer.toBinaryString(N);

            int[] arr = new int[b.length()];

            for(int j = 0; j < b.length(); j++){
                arr[j] = b.charAt(j)-48;
            }

            for(int j = 0; j < arr.length; j++){
                stack.push(arr[j]);
            }



            int n = 0;
            while(!stack.isEmpty()){
                if(stack.pop() == 1){
                    list.add(n);
                    n++;
                } else n++;
            }

            for(int j = 0; j < list.size(); j++){
                System.out.print(list.get(j) + " ");
            }
        }

    }
}
