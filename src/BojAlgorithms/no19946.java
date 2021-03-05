package BojAlgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class no19946 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Long [] arr = new Long[100];

        List<Long> list = new ArrayList<Long>();

        long n = sc.nextLong();
        int i = 0;

        for(i = 0; i <= 64; i++){
            arr[i] = ((long) Math.pow(2, i) - 1);
        }
        for(int j = 0; j < arr.length; j++){
            if (n % arr[i] == 0) {
                list.get(i);
                System.out.println(i);
            }
        }
    }
}
