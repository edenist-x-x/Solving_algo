package BojAlgorithms;
/*
BOJ_20499 Darius님 한타 안 함?
 */
import java.io.*;

public class no20499 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String kda = br.readLine();
        String[] c = kda.split("/");
        int[] num = new int[3];

        for(int i = 0; i < 3; i++){
            num[i] = Integer.parseInt(c[i]);
        }

        if(num[0] + num[2] < num[1] || num[1] == 0) sb.append("hasu");
        else sb.append("gosu");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
//        for(int i = 0; i < 3; i++){
//            System.out.print(c[i] + " ");
//        }
//        System.out.println();
    }
}
