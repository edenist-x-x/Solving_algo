package BojAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1271 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String a = br.readLine();
            String b = br.readLine();

            StringTokenizer st = new StringTokenizer(a, " ");

            a =
            b = Integer.toString(Integer.parseInt(st.nextToken()));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
