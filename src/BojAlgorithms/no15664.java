package BojAlgorithms;

import java.io.*;
import java.util.*;

public class no15664 {
    static int N, M;
    static int[] nums;
    static int[] res;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static Iterator<String> it;
    static Set<String> set;

    public static void setComb(int cnt, int start) {

        if (cnt == M) {
            StringBuilder sb = new StringBuilder();
            for (int x : res) {
                sb.append(x).append(" ");
            }
            set.add(sb.toString());
            return;
        }
        for(int i = start; i < N; i++){
            res[cnt] = nums[i];
            setComb(cnt + 1, i + 1);
        }
    }
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        res = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);
        set = new LinkedHashSet<String>();
        setComb(0, 0);
        it = set.iterator();

        while (it.hasNext()) {
            bw.write(it.next());
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
