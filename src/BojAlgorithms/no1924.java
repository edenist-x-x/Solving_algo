package BojAlgorithms;
import java.util.Scanner;

public class no1924 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int month = sc.nextInt();
        int date = sc.nextInt();

        int[] monthOfYear = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int sum = 0;

        for(int i = 1; i <= 12; i++){
            if(i == month){
                break;
            }
            sum += monthOfYear[i];
        }

        sum += date;

        switch(sum % 7){
            case 0 :
                System.out.println("SUN");
                break;
            case 1:
                System.out.println("MON");
                break;
            case 2:
                System.out.println("TUE");
                break;
            case 3:
                System.out.println("WED");
                break;
            case 4:
                System.out.println("THU");
                break;
            case 5:
                System.out.println("FRI");
                break;
            case 6:
                System.out.println("SAT");
                break;
        }
    }
}
