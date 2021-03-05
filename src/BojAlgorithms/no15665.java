package BojAlgorithms;

import java.io.*;
import java.util.*;

public class no15665 {
    static int N, M;
    static int[] nums;
    static int[] res;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static Set<String> set;
    static Iterator<String> it;
    public static void nondupliC(int cnt) {
        if (cnt == M) {
            StringBuilder sb = new StringBuilder();
            for (int re : res) {
                sb.append(re).append(" ");
            }
            set.add(sb.toString());
            return;
        }
        for(int i = 0; i < N; i++){

            res[cnt] = nums[i];


            nondupliC(cnt + 1);

        }
    }
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        res = new int[M];
        set = new LinkedHashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        nondupliC(0);
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
