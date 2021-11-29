package Jungol.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no1692 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        int[] num1 = new int[3];
        int[] num2 = new int[3];


        int h1 = b / 100;
        int t1 = (b - (h1 * 100)) / 10;
        int o1 = b % 10;


        num2[0] = o1;
        num2[1] = t1;
        num2[2] = h1;


        System.out.println(a * num2[0]);
        System.out.println(a * num2[1]);
        System.out.println(a * num2[2]);
        System.out.println(a * b);
    }
}
