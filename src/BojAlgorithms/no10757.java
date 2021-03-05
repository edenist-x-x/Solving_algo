package BojAlgorithms;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class no10757 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] nums = br.readLine().split(" ");

            System.out.println(new BigInteger(nums[0]).add(new BigInteger(nums[1])));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
