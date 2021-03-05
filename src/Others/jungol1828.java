package Others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class jungol1828 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 화학 물질 수 입력

        int[][] ref = new int[N][2];    // 각 물질의 최저 보관온도와 최고보관온도를 담을 배열 선언
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            ref[i][0] = Integer.parseInt(st.nextToken());   // 최저온도 입력
            ref[i][1] = Integer.parseInt(st.nextToken());   // 최고온도 입력
        }
        int cnt = 1;    // N의 범위가 1부터이니까, 냉장고 또한 1부터 시작

        Arrays.sort(ref, new Comparator<int[]>() {  // 입력된 배열 소팅
            @Override
            public int compare(int[] o1, int[] o2) {    // 최고온도를 오름차순으로 소팅해준다.
                if (o1[1] == o2[1]) {   // 만약 각 화학물질 중 최고온도가 같은 경우일 때
                    return o1[0] - o2[0];   // 최저온도를 오름차순으로 정렬
                }
                return o1[1] - o2[1];
            }
        });
        int idx = ref[0][1];    // 처음 입력된 화학물질의 최고온도를 저장
        for(int i = 0; i < N; i++){
            if (idx < ref[i][0]) {  // 만약 이전의 최고온도가 시행되는 최저온도보다 작다면 포함되는 영역이 아니기 때문에 냉장고가 추가되어야 한다.
                idx = ref[i][1];    // 이전의 최고온도를 업데이트
                cnt++;  // 냉장고 카운트 증가 .
            }
        }

        System.out.println(cnt);
    }
}