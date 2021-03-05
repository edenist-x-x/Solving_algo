package BojAlgorithms;

import java.io.*;

public class no15552 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            int sum = 0;
            String[] str = br.readLine().split(" ");
            for(int j = 0; j < str.length; j++){
                sum += Integer.parseInt(str[j]);
            }
            bw.write(String.valueOf(sum));
            bw.newLine();
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
