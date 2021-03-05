package BojAlgorithms;

import java.util.Scanner;

public class no3040 {
    static int[] a;
    static int[] res;
    static int sum = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = new int[9];
        res = new int[7];
        int fake1 = 0; //  일곱 난쟁이가 아닌 사람 1
        int fake2 = 0; //  일곱 난쟁이가 아닌 사람 2
        for(int i = 0; i < 9; i++){
            a[i] = sc.nextInt();
            sum += a[i]; // 입력을 받음과 동시에 모든 수의 합을 구한다.
        }
        for(int i = 0; i < 8; i++){ // 모든 경우를 헤아리기보다, 일곱난쟁이가 아닌 2명을 뽑아내는 작업.
            for(int j = i; j < 9; j++){
                if (sum - a[i] - a[j] == 100 && i != j) { // 총 합에서 난쟁이가 아닌 두사람을 각각 빼면 100이 되게, 그리고 서로 겹치는 인덱스가 없도록 조건을 둔다.
                    fake1 = a[i]; // 난쟁이가 아닌 사람의 모자의 숫자 색출
                    fake2 = a[j];
                }
            }
        }
        for(int i = 0; i < 9; i++){
            if(a[i] == fake1 || a[i] == fake2) a[i] = 0; // 9명을 순회하며 난쟁이가 아닌 사람의 모자의 배열값을 0으로 바꿔준다.
        }
        for(int i = 0; i < 9; i++){
            if (a[i] == 0) continue; // 만약 해당 인덱스의 값이 0이라면 넘기고
            else
                System.out.println(a[i]); // 0이 아닐 경우, 즉 일곱난쟁이일 경우 출력

        }


    }

}
