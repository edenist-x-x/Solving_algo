package BojAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no20113 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] map = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            map[Integer.parseInt(st.nextToken())]++;
        }

        int max = Integer.MIN_VALUE;
        int point = 0;
        int cnt = 0;
        int mmax = Integer.MIN_VALUE;

        for(int i = 1; i <= N; i++) {
            if (map[i] != 0) {
                if (map[i] > max) {
                    max = map[i];
                    point = i;
                }
            }
        }
//
//        for(int i = 0; i < N + 1; i++){
//            System.out.print(map[i] + " ");
//        }
//        System.out.println();
//        System.out.println("max : " + max + " point : " + point);
        boolean flag = false;
        if(map[0] == N) flag = true;

//        Arrays.sort(map);
        for(int i = 0; i <= N; i++){
            if(map[i] == 0) continue;
            if(map[i] >= mmax){
                mmax = map[i];
            }
        }

        for(int i = 0; i <= N; i++){
            if(mmax == map[i]){
                cnt++;
            }
        }
//        for(int i = 0; i < N + 1; i++){
//            System.out.print(map[i] + " ");
//        }
//        System.out.println();
//        System.out.println("mmax = " + mmax + " cnt : " + cnt + " flag " + flag);

        if(!flag && cnt == 1){
            System.out.println(point);
        } else if(cnt >= 2){
            System.out.println("skipped");
        }

    }
}
