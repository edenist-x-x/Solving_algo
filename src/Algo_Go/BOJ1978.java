package Algo_Go;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1978 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());

            boolean[] prime = new boolean[num];
            if(num < 2){
                for(int j = 0; j < num; j++){
                    prime[j] = true;
                }
            } else {
                prime[0] = prime[1] = true;

                for(int j = 2; j * j < num; j++){
                    if(!prime[j]){
                        for(int k = j * j; k <= num; j++){
                            prime[k] = true;
                        }
                    }
                }
            }
            for(int j = 1; j <= N; j++){
                if(!prime[j]) {

                }
            }

        }



        System.out.println(cnt);


    }
}
