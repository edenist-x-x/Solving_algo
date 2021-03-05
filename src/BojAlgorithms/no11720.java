package BojAlgorithms;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class no11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String size = br.readLine();
        String num = br.readLine();
        int[] n = new int[num.length()];
        int sum = 0;

        for(int i = 0; i < num.length(); i++){
            n[i] = Integer.parseInt(String.valueOf(num.charAt(i)));
        }
        for(int i = 0; i < n.length; i++){
            sum += n[i];
        }
        System.out.println(sum);
    }
}
