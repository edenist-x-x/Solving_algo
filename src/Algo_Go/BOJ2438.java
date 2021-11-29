package Algo_Go;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2438 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char star = '*';

        for(int i = 0; i < N; i++){
            for(int j = 0; j < i + 1; j++){
                System.out.print(star);
            }
            System.out.println();
        }

    }
}
