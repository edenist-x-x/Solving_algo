package CodeTest.Delivery_Hero;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Task3 {
    static int[] arr, temp;
    static int start, cnt;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());


        int res[];
        res = solution(M);

        for(int i = start; i < cnt; i++){
            System.out.print("R[" + i + "]" + " = " + res[i] + "     ");
        }

    }
    public static int[] solution(int N) {
        // write your code in Java SE 8
        list = new ArrayList<>();
        temp = new int[100];
        int sum = 0;
        cnt = 0;
        for(int i = 1; sum + i < N; i += 2){
            temp[cnt++] = i;
            sum += i;
        }

        start = 0;
        int rest = N - sum;
        if ( rest % 2 == 0){
            temp[cnt - 1] += rest;
        } else if(rest > temp[cnt - 1]){
            temp[cnt++] = rest;
        } else {
            start = 1;
            temp[cnt - 1] += rest + 1;
        }
        for(int i = 0; i < temp.length; i++){
            if(temp[i] != 0) list.add(temp[i]);
        }
        arr = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}
