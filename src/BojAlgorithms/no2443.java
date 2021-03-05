package BojAlgorithms;

import java.util.Scanner;

/*
*   입력 : 5
*
*   출력
*            *********  // 2 * n - 1개
 *             ******   // 2 * n - 2개
 *              ****    // 2 * n - 3개
 *               **     // 2 * n - 4개
 *                *     // 2 * n - 5개
 *
* */
public class no2443 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i = 1; i <= n; i++){
            for(int j = 1; j < i; j++){
            System.out.print(" ");
            }
            for(int j = 2 * n - (i * 2-1); j > 0; j--){
                    System.out.print("*");
            }
            System.out.println();
        }
    }
}
