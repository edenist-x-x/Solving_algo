package BojAlgorithms;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class no2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int[] tower = new int[n + 1];
        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++){
            tower[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = n; i > 0; i--){
            label:
            for(int j = i - 1; j > 0; j--){
                if(tower[i] == 0 || i == 1){
                    stack.add(0);
                    break;
                }
                if (tower[i] - tower[j] <= 0) {
                    stack.add(j);
                    break;
                }
                if (tower[i] - tower[j] > 0) {
                    int k = 1;
                    while(j - k >= 0){
                        if(tower[i] - tower[j - k] > 0){
                            if(j - k <= 0){
                                stack.add(0);
                                break label;
                            }else
                                k++;
                        }
                        if(tower[i] - tower[j - k] <= 0){
                            stack.add(j - k);
                            break label;
                        }
                    }
                }
            }
        }
        stack.add(0);
        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
//        System.out.println(Arrays.toString(tower));

    }
}
