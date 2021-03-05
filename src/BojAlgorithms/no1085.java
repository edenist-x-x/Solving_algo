package BojAlgorithms;

import java.util.Scanner;

public class no1085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        System.out.println(Math.min(Math.min(w - x, y), Math.min(x, h - y)));
    }
}
