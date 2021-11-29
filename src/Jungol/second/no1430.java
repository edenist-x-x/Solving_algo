package Jungol.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no1430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int res = A * B * C;

        String num = String.valueOf(res);

        int[] number = new int[10];

        for(int i = 0; i < num.length(); i++){
            number[num.charAt(i) - 48]++;
        }

        for(int i = 0; i < number.length; i++){
            System.out.println(number[i]);
        }
    }
}
