package Jungol.Begineer.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1341 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean flag = false;
        int idx = 0;
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        if(s < e){
            while(!flag){
                int n = 1;
                if (s >= e) {
                    flag = true;
                }
                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++){
                        System.out.print(s + " * " + n + " = ");
                        System.out.printf("%2d", (s * n));
                        System.out.print("   ");
                        n++;
                    }
                    System.out.println();
                }
                System.out.println();
                s++;
                idx++;
            }
        } else if(s > e){
            while(!flag){
                int n = 1;
                if (s <= e) {
                    flag = true;
                }
                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++){
                        System.out.print(s + " * " + n + " = ");
                        System.out.printf("%2d", (s * n));
                        System.out.print("   ");
                        n++;
                    }
                    System.out.println();
                }
                System.out.println();
                s--;
                idx++;
            }
        } else {
            int n = 1;
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    System.out.print(s + " * " + n + " = ");
                    System.out.printf("%2d", (s * n));
                    System.out.print("   ");
                    n++;
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
