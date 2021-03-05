package SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class no1208 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i= 1; i <= 10; i++){
            int d = sc.nextInt();

            int[] box = new int[100];

            for(int j = 0; j < 100; j++){
                box[j] = sc.nextInt();
            }

            for(int j = 0; j < d; j++){
                Arrays.sort(box);
                box[0]++;
                box[99]--;
            }
            Arrays.sort(box);

            System.out.println("#" + i + " " + (box[99] - box[0]));
        }

    }
}
