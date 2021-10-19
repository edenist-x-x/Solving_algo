package BojAlgorithms;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class no20124 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        ArrayList<Mens> list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            list.add(new Mens(name, score));
        }

        Collections.sort(list);

        sb.append(list.get(0).name);
        bw.write(sb.toString());
        bw.flush();
        bw.close();


    }
    static class Mens implements Comparable<Mens>{
        String name;
        int score;

        public Mens(String name, int score) {
            this.name = name;
            this.score = score;
        }


        @Override
        public int compareTo(Mens mens) {
            if(this.score == mens.score){
                return this.name.compareTo(mens.name);
            }else
            return mens.score - this.score;
        }
    }
}
