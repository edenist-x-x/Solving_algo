package BojAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class no2338 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {

            BigInteger a = new BigInteger(br.readLine());
            BigInteger b = new BigInteger(br.readLine());
            System.out.println(a.add(b));
            System.out.println(a.subtract(b));
            System.out.println(a.multiply(b));
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
