package SWEA;

import java.io.*;
import java.util.StringTokenizer;

public class no1486 {
    static int T;
    static int N, H;
    static int[] height;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb;
        T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            sb = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            height = new int[N];
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++){
                height[i] = Integer.parseInt(st.nextToken());
            }
            // 부분집합 --> H를 넘는 가장 작은 수 ? 찾아내자.
            min = Integer.MAX_VALUE;
//            byBitMasking();
            combination(0, 0);
            sb.append("#").append(tc).append(" ").append(min).append("\n");
            bw.write(sb.toString());

        }
        bw.flush();
        bw.close();
    }

    // 01. 비트마스킹을 이용한 풀이
    static void byBitMasking() {
        // 1 << N --> 비트 왼쪽으로 --> X2, 이것을 N번하면, 결국 2^N
        for (int i = 1; i < (i << N); i++) { // i : 요소의 포함 상태를 비트적으로 나타냄.
            int sum = 0;
            for(int j = 0; j < N; j++){
                if ((i & (1 << j)) > 0) { // i 비트에 j가 포함되어 있다면..
                    sum += height[j];
                    // 이미 만족했다면, 계속 더해줄 필요는 없다.
                    if (sum - H > min) {
                        break;
                    }
                }
            }
            // H를 넘으면서 차이는 최소화 해주자.
            if (sum >= H && sum - H < min) {
                min = sum - H;
            }
        }
    }

    // 02. 재귀를 이용한 풀이. (컴비네이션 / 조합)
    static void combination(int start, int sum) {
        if (sum >= H && sum - H < min) {
            min = sum - H;
        }
        // 종료 조건
        if (start == N) {
            return;
        }
        // 재귀 실행
        for(int i = start; i < N; i++){
            combination(i + 1, sum + height[i]);
        }
    }
}
