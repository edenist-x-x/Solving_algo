package BojAlgorithms;

import java.util.Scanner;

public class no8370 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int k1 = sc.nextInt();
        int n2 = sc.nextInt();
        int k2 = sc.nextInt();

        int result = (n1 * k1) + (n2 * k2);

        System.out.println(result);
    }
}
