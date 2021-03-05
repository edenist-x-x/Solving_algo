package BojAlgorithms;

import java.io.*;
import java.util.ArrayList;

public class no5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> list = new ArrayList<>();

        int num;
        for(int i = 1; i <= 30; i++){
            list.add(i);
        }
        for(int i = 0; i < 28; i++){
            num = Integer.parseInt(br.readLine());
            for(int j = 0; j < list.size(); j++){
                if(list.get(j) == num){
                    list.remove(j);
                }
            }
        }
        for(int r : list){
                bw.write(String.valueOf(r));
                bw.newLine();
                bw.flush();
        }
        br.close();
        bw.close();

    }
}
