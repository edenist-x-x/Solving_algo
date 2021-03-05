/*
*
* BOJ_1759 암호문 만들기
*
* */

package BojAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class no1759 {
    static int L, C;
    static ArrayList<Character> pws;
    static char[] pw = new char[C];
    static int mcnt, jcnt;

    static void combination(int cnt, int start){
        if (cnt == L) {
            mcnt = 0;
            jcnt = 0;
            for(int i = 0; i < L; i++){
                if (pws.get(i) == 'a' || pws.get(i) == 'e' || pws.get(i) == 'i' || pws.get(i) == 'o' || pws.get(i) == 'u') {
                    mcnt++;
                }else jcnt++;
            }
            if (mcnt >= 1 && jcnt >= 2) {
                for(int i = 0; i < pws.size(); i++){
                    System.out.print(pws.get(i));
                }
                System.out.println();
                return;
            }
        }

        for(int i = start; i < C; i++){
            pws.add(pw[i]);
            combination(cnt + 1, i + 1);
            pws.remove(pws.size() - 1); //
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        pws = new ArrayList<>();
        pw = new char[C];
        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < pw.length; i++){
            pw[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(pw);
        combination(0, 0);

    }
}
