package Algo_Go;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ10870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();

        list.add(0);
        list.add(1);

        for(int i = 2; i <= n; i++){
            int a = list.get(i - 2);
            int b = list.get(i - 1);
            list.add(a + b);
        }
        if(n == 0) System.out.println(0);
        else  System.out.println(list.get(list.size() - 1));

    }
}
