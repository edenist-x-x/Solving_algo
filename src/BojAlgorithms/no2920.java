package BojAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] ac = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] dc = {8, 7, 6, 5, 4, 3, 2, 1};
        int acnt = 0;
        int dcnt = 0;

        String[] str = br.readLine().split(" ");
        int[] ipt = new int[str.length];
        for(int i = 0; i < str.length; i++){
            ipt[i] = Integer.parseInt(str[i]);
        }
        for(int i = 0; i < ipt.length; i++){
            if (ipt[i] == ac[i]) {
                acnt++;
            }
            if (ipt[i] == dc[i]) {
                dcnt++;

            }
        }
        if(acnt == 8){
            System.out.println("ascending");
        }
        else if(dcnt == 8){
            System.out.println("descending");
        }
        else
            System.out.println("mixed");
    }
}
