package BojAlgorithms;

import java.io.*;
import java.util.ArrayList;

public class no5597 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> list = new ArrayList<>();

        int num;
        for(int i = 1; i <= 30; i++){ // 30명의 출석번호 1~30 리스트에 넣기
            list.add(i);
        }
        for(int i = 0; i < 28; i++){ // 28명의 출석번호 받기
            num = Integer.parseInt(br.readLine());
            for(int j = 0; j < list.size(); j++){ // 입력받은 num과 리스트 순차적으로 비교하면서 만약 같을경우, 지워줌.
                if(list.get(j) == num){
                    list.remove(j);
                }
            }
        }
        for(int r : list){ // 출력
                bw.write(String.valueOf(r));
                bw.newLine();
                bw.flush();
        }
        br.close();
        bw.close();

    }
}
