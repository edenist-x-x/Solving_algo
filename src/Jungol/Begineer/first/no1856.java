package Jungol.Begineer.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1856 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int way = 1;
        int num = 1;
        int tmp = 0;
        for(int i = 0; i < n; i++){
            switch(way){
                case 1:
                    for(int j= 0; j < m; j++){
                        System.out.print(num + " ");
                        num++;
                    }
                    System.out.println();
                    tmp = num;
                    way = 2;
                    break;
                case 2:
                    for(int j = 0; j < m; j++){
                        System.out.print((tmp + m - 1) + " ");
                        tmp--;
                        num++;
                    }
                    System.out.println();
                    way = 1;
                    break;
            }
        }
    }
}
