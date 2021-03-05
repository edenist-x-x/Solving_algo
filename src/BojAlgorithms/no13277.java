package BojAlgorithms;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class no13277 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] a = br.readLine().split(" ");

            System.out.println(new BigInteger(a[0]).multiply(new BigInteger(a[1])));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
