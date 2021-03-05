package BojAlgorithms;

import java.util.*;

public class no2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int res = 0;    // 봉지 수를 카운트 해줄 변수

        while(true){
            if (N % 5 == 0) { // N이 5로 나누어 떨어지면, 봉지 수를 N을 5로 나눈 값 그대로 출력한다 (이게 최소가 된다)
                res += N / 5;
                System.out.println(res);
                break;
            }
            else{   // N이 5로 나누떨어지지 않을 경우, 3으로 나누떨어지거나 아무것도 아닐경우이므로
                N -= 3; // N에서 3을 빼주고 봉지수 증가시켜줌. 그리고 이걸 계속 반복해서
                res++;
            }
            if (N < 0) {    // 만약 N이 0 미만일 경우에는 정확하게 N 킬로그램을 만들수 없기때문에 -1 출력
                System.out.println("-1");
                break;
            }
        }
    }
}
