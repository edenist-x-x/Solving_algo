package Algo_Go;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ2460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] now = new int[10];

        for(int i = 0; i < 10; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int out = Integer.parseInt(st.nextToken());
            int in = Integer.parseInt(st.nextToken());

            if(i == 0) {
                out = 0;
                now[i] += in;
            }
//            else if(i == 9){
//                in = 0;
//                now[i] -= out;
//            }
            else {
                now[i] = now[i-1] - out;
                now[i] += in;
            }

        }
        Arrays.sort(now);
        System.out.println(now[9]);
    }
}
