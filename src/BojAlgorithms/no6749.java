package BojAlgorithms;

import java.util.Scanner;

public class no6749 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int Y = sc.nextInt();
        int M = sc.nextInt();

        int O = 0;

        O = (M - Y) + M;
        System.out.println(O);
    }
}
