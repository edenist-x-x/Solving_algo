package BojAlgorithms;

import java.util.Scanner;

public class no1297 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double realInch = sc.nextInt();
        double hRate = sc.nextInt();
        double wRate = sc.nextInt();

        if(realInch >= 5 && hRate >= 1 && wRate > hRate){
            double iRate =  Math.sqrt((Math.pow(hRate, 2) + Math.pow(wRate, 2)));
            double realHeight = (realInch/iRate) * hRate;
            double realWidth = (realInch/iRate) * wRate;

            System.out.printf("%.0f", realHeight);
            System.out.printf(" ");
            System.out.printf("%.0f", realWidth);
        }


    }
}
