package Algo_Go;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if(b > a){
            int tmp = 0;
            tmp = a;
            a = b;
            b = tmp;
        }
        System.out.println(gcd(a, b));
        System.out.println(lcm(a, b));
    }
    static int gcd(int a, int b){ // 최대공약수
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    static int lcm(int a, int b){ // 최소공배수
        return a * b / gcd(a, b);
    }
}
