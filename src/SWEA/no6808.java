package SWEA;

import java.io.*;
import java.util.StringTokenizer;

public class no6808 {
    static int[] a = new int[9]; // 규영이 카드 담은 배열
    static int[] b = new int[9]; // 인영이 카드 담은 배열
    static boolean[] v; // 체크
    static boolean[] nums; // 전체 숫자 카드 담은 배열
    static int win, lose; // 이기거나, 질 경우를 카운트 하는 변수

    public static void permutation(int cnt, int apoint, int bpoint) {
        // 매개변수로는, 1 ~ 9번의 게임을 진행하는동안 카운트해줄 cnt,
        // 규영이가 이길 경우 합산 점수인 apoint, 인영이가 이길 경우 포인트 합산 bpoint
        if (cnt == 9) { // 종료 조건
            if(apoint > bpoint) // 규영이의 총 합산점수가 높다면
                win++; // 이길 경우의 카운트를 증가
            if(apoint < bpoint) // 인영이의 총 합산점수가 높다면, 즉 규영이가 진다면
                lose++; // 질 경우의 카운트를 증가해준다.
            return;
        }
        for(int i = 0; i < 9; i++){ // 라운드 수만큼 반복하면서            // 호출 & 실행
            if(!v[i]) { // 만약 해당 인덱스의 방문처리가 되어있지 않을 때
                v[i] = true; // 방문처리를 해주고
                if (a[cnt] > b[i]) { // 규영이의 카드의 수가 인영이의 카드보다 클 경우
                    permutation(cnt + 1, apoint + a[cnt] + b[i], bpoint); // 카운트를 증가시키고 규영이가 이길 때의 총합을 더해주는 변수, bpoint를 매개변수로 재귀호출.
                }
                else // 인영이의 카드의 수가 규영이의 카드보다 클 경우
                    permutation(cnt + 1, apoint, bpoint + a[cnt] + b[i]);

                v[i] = false;  // 방문 초기화
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());

        for(int tc = 1; tc <= T; tc++){
            st = new StringTokenizer(br.readLine());
            win = 0;
            lose = 0;
            v = new boolean[9]; // 인영이 카드의 방문처리에 필요한 배열.
            nums = new boolean[19]; // 규영이가 선택하고 남은 카드를 인영이의 배열에 넣어주기 위한 방문처리 배열 (입력용)
            for(int i = 0; i < 9; i++){
                a[i] = Integer.parseInt(st.nextToken()); // 규영이의 카드를 순서대로 입력받고
                nums[a[i]] = true; // 규영이가 택한 카드를 전체 카드목록에서 방문처리해준다.
            }
            int idx = 0; // 임시변수를 증가시키면서 전체 카드목록 중, 규영이가 뽑지않은 카드를 인영이 카드 목록에 넣어줘야한다.
            for(int i = 1; i <= 18; i++){
                if(!nums[i]){ // 규영이가 선택한 카드가 아닐 경우
                    b[idx] = i; // 인영이의 카드목록에 넣어준다.
                    idx++; // 인덱스 증가
                }
            }
            permutation(0, 0, 0); // 순열 함수 호출

            sb.append("#").append(tc).append(" ").append(win).append(" ").append(lose).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
