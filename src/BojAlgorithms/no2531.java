package BojAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no2531 {
    static int N, d, k, c;
    static int[] s;
    static int[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 접시의 수
        d = Integer.parseInt(st.nextToken());   // 초밥 가짓 수
        k = Integer.parseInt(st.nextToken());   // 연속해서 먹는 접시 수
        c = Integer.parseInt(st.nextToken());   // 쿠폰 번호

        s = new int[N];
        v = new int[d + 1];

        for(int i = 0; i < N; i++){
            s[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(process());
    }

    private static int process() {
        int max, cnt = 0;

        for(int i = 0; i < k; i++){ // 처음 k개의 접시를 먹은 것 초기화
            if(v[s[i]] == 0) cnt++;
            v[s[i]]++;
        }
        max = cnt;
        for(int i = 1; i < N; i++){
            if (max <= cnt) {
                if(v[c] == 0) max = cnt + 1; // 쿠폰에 해당되는 초밥을 먹지 않았을 경우에, cnt 1 증가.
                else max = cnt;
            }
            v[s[i - 1]]--;
            if(v[s[i - 1]] == 0) cnt--;

            if(v[s[(i + k - 1) % N]] == 0) cnt++;
            v[s[(i + k - 1) % N]]++;
        }
        return max;
    }
}
