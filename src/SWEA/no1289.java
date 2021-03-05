package SWEA;

import java.util.Scanner;

public class no1289 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int tc = 1; tc < T; tc++){
            String mem = sc.next();
            int[] arr = new int[mem.length()];

            for(int i = 0; i < arr.length; i++){
                arr[i] = mem.charAt(i) - '0';
            }
            int cnt = arr[0];   // 배열의 시작이 1로 시작할 경우, 카운트를 하나 더 해주기 위한 초기화.
            for(int i = 1; i < arr.length; i++){
                    if (arr[i] != arr[i - 1]) { // 인접한 배열의 원소와 다를 경우
                        cnt++;
                    }
            }
            System.out.println("#" + tc + " " + cnt);
        }
    }
}
