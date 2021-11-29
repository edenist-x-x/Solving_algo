package Jungol.Begineer.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no2046 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        switch (m){
            case 1:
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < n; j++){
                        System.out.print(i + 1 + " ");
                    }
                    System.out.println();
                }
                break;
            case 2:
                int way = 1;
                for(int i = 0; i < n; i++){
                    if(i % 2 == 0){
                        for(int j = 0; j < n; j++){
                            System.out.print(j + 1 + " ");
                        }
                    } else {
                        for(int j = n; j > 0; j--){
                            System.out.print(j + " ");
                        }
                    }
                    System.out.println();
                }
                break;
            case 3:
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < n; j++){
                        System.out.print((i + 1) * (j + 1) + " ");
                    }
                    System.out.println();
                }
                break;
        }
    }
}
