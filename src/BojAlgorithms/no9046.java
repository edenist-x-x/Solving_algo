package BojAlgorithms;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/*
a b c d e f g h i j k l m n o p q r s t u v w x y z
w g h u v i j x p q r s t a c d e b f k l m n o y z
hello there
*/
public class no9046 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        char[] alpha = {'w', 'g', 'h', 'u', 'v', 'i', 'j', 'x', 'p', 'q', 'r', 's', 't', 'a', 'c', 'd', 'e', 'b', 'f', 'k', 'l', 'm', 'n', 'o', 'y', 'z'};

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            String str = br.readLine();
            int[] cnt = new int[alpha.length];
            char[] a = str.toCharArray();
            ArrayList<Integer> list = new ArrayList<>();
            int idx = 0;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < alpha.length; j++) {
                    if (a[i] == alpha[j]) {
                        cnt[j] += 1;
                    }
                }
            }
            for (int i = 0; i < cnt.length; i++) {
                if (cnt[i] >= max) {
                    max = cnt[i];
                    list.add(cnt[i]);
                    idx = i;
                }
            }
            Collections.sort(list, Collections.reverseOrder());

            if (list.size() > 1) {
                if (list.get(0) == list.get(1)) {
                    sb.append("?").append("\n");
                } else sb.append(alpha[idx]).append("\n");

            } else sb.append(alpha[idx]).append("\n");


        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
    }
}
