package BojAlgorithms;

import java.util.*;

public class no20299 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();	// 신청한 동아리 수(N) 입력
        int S = sc.nextInt();	// 팀원 3명의 능력의 합에 대한 조건 S 입력 ( 3명 능력 합 > S일 경우 통과 )
        int M = sc.nextInt();	// 개개인별 능력에 대한 조건 M 입력 ( 개인별 능력 > M일 경우 통과 )
        int team[][] = new int[N][3];	// 행이 팀의 개수 N이며 각각 팀원 3명씩을 포함하고 있는 이차원배열 team 선언
        boolean isBan[] = new boolean[N]; // isBan이 참일 경우, 알고리즘 스마트클럽에 참여하지 못한다. 즉, 탈락.
        int[] tot = new int[N];	// 팀원 전체 능력 합을 담은 배열 tot 선언.
        for(int i = 0; i < N; i++) {	// 각각의 팀 별 팀원의 능력치 입력
            for(int j = 0; j < 3; j++) {
                team[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < N; i++) {	// 팀원 전체 능력 합을 구하기 위한 연산
            for(int j = 0; j < 3; j++) {
                tot[i] += team[i][j];
            }
        }
        for(int i = 0; i < N; i++) {	// 해당 팀의 통과여부를 확인하기 위한 연산
            for(int j = 0; j < 3; j++) {
                if(team[i][j] < M || tot[i] < S){	// 팀원 개개인의 능력이 M 미만이거나 팀 전체 능력치의 합이 S 미만일 경우
                    isBan[i] = true;	// 스마트클럽에 참가하지 못하도록 boolean 타입의 isBan 배열의 팀에 해당하는 인덱스를 참으로 해줌.
                    break;
                }
            }
        }
        int cnt = 0; // 통과한 팀의 수를 저장하는 cnt 변수 선언
        for(int i = 0; i < N; i++) {
            if(!isBan[i])	// 만약 i번째 팀이 통과한다면, cnt 1씩 증가
                cnt++;
        }
        System.out.println(cnt); // 통과한 팀의 수 출력
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < 3; j++) {
                if(!isBan[i]) { // 통과한 팀의 각 개인 능력을 출력.
                    System.out.print(team[i][j] + " ");
                }
            }
        }
    }

}
