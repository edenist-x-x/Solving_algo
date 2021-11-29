package Others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class test {
    static int N, M;
    static int[] path;
    static int[] isSelected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        switch (M){
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;

        }

    }
    static void run1(int lev){

    }

    static void run2(int lev, int start) {
        if(lev == N){
            print();
        }
        for(int i = start; i <= 6; i++){

        }
    }

    static void run3(int lev) {
        if (lev == N) {
            print();
        }
        for(int i = 1; i <= 6; i++){
            if(isSelected[i] == 1) continue;
            
        }
    }
    static void print(){
        for(int i = 0; i < N; i++){
            System.out.println(path[i]);
        }
    }
}