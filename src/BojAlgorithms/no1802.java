package BojAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no1802 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            String str = br.readLine();
            char[] arr = str.toCharArray();


            if (arr.length % 2 == 0) System.out.println("NO");
            else if (check(arr, 0, arr.length - 1)){
                System.out.println("YES");
            } else System.out.println("NO");
        }
    }
    static boolean check(char arr[], int start, int end){
        if(start >= end) return true;
        if(isRight(arr, start, end)){
            int mid = (start + end) / 2;
            return check(arr, start, mid - 1) && check(arr, mid + 1, end);
        } else return false;

    }
    static boolean isRight(char arr[], int start, int end){
        if(start >= end) return true;
        if(arr[start] != arr[end]) return isRight(arr, start + 1, end - 1);
        else return false;
    }
}
