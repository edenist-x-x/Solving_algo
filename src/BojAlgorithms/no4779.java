package BojAlgorithms;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class no4779 {
    static char[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String tmp;
        while((tmp = br.readLine())!=null){
            int N = (int)Math.pow(3,Integer.parseInt(tmp));
            arr = new char[N];
            for(int i=0;i<N;i++)
                arr[i] = ' ';
            makeString(0,N-1,N);
            for(char ch:arr)
                bw.write(ch);
            bw.newLine();
            bw.flush();
        }
        System.out.println(sb);
    }
    static void makeString(int first, int last, int len){
        if(len==1){
            arr[first] = '-';
            return;
        }
        int tmp_len = len/3;
        makeString(first,first+tmp_len-1,tmp_len);
        makeString(last-tmp_len+1,last,tmp_len);
    }
}