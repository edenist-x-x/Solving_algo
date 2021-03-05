package BojAlgorithms;


import java.io.IOException;
import java.util.Scanner;

/*
 *
 * 스위치 켜고 끄기
 * 입력 : 1. 스위치 100개 이하.
 *       2. 각 스위치의 상태 on : 1, off : 0 사이에 공백.
 *       3. 학생 수. (100 이하)
 *       4. 여기서부터 마지막까지 한 줄에 학생의 성별 / 학생이 받는 수. (남 : 1, 여 : 2) 받는 수 <= 스위치 개수
 *       5. 성별 받는 수 사이 공백 존재.
 *
 *       남 (1) : 스위치 번호가 자기가 받은 수의 배수면 상태 바꿈. ex) 3번 받음. 그럼 3의 배수 스위치 상태 변경
 *       여 (2) : 자기가 받은 수의 스위치 중심으로 좌우 대칭이면서 가장 많은 스위치 포함한 구간 변경. / 대칭없을땐 그자리만 변경
 *
 * */
public class no1244 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int sw = 0;
        int gnb = 0;
        int snum = 0;
        boolean[] swArr = new boolean[n + 1];
        for(int i = 1; i < n + 1; i++){ // 1부터 n까지 0과 1을 받아들여서 swArr 배열에 저장.
            sw = sc.nextInt();
            if(sw == 1){
                swArr[i] = true;
            }
        }

        int student = sc.nextInt();
        for(int i = 0; i < student; i++){

            gnb = sc.nextInt();
            snum = sc.nextInt();

            if(gnb == 1){ // 남자일 경우, 자신과 자신의 배수 인덱스의 값(스위치)을 반대로 바꾸어줌.
                for(int j = snum; j <= n; j += snum){
                    swArr[j] = !swArr[j];
                }
            }
            if(gnb == 2){ // 여자일 경우
                int index = 1; // 자신의 위치 중심으로 좌우 연산을 하기위해 인덱스 선언.
                swArr[snum] = !swArr[snum];
                while(snum - index > 0 && snum + index <= n){ // 해당 조건 = 범위 안에 있을 경우 loop 실행
                    if(swArr[snum - index] == swArr[snum + index]){ // 자신의 위치 반경 앞, 뒤 index만큼 같다면
                        swArr[snum - index] = !swArr[snum - index]; // 스위치를 끄거나 켬.
                        swArr[snum + index] = swArr[snum - index];
                        index++;
                    }
                    else
                        break;

                }
            }
        }
        for(int i = 1; i <= n; i++){
            if(i % 20 == 1 && i != 1){ // 20번째까지 한줄로 출력하고 그다음부터는 다음줄에 출력하도록 함.
                System.out.println();
            }
            if(swArr[i]){ // 참이라면 1
                System.out.print(1 + " ");
            }
            else // 거짓이라면 0
                System.out.print(0 + " ");
        }
        System.out.println();


    }
}
