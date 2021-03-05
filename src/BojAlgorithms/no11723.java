package BojAlgorithms;

import java.io.*;
import java.util.StringTokenizer;

public class no11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int S = 0;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            int x;
            switch (cmd) {
                case "add":
                    x = Integer.parseInt(st.nextToken());
                    S |= 1 << x;
                    break;
                case "remove":
                    x = Integer.parseInt(st.nextToken());
                    S &= ~(1 << x);
                    break;
                case "check":
                    x = Integer.parseInt(st.nextToken());
                    if((S & 1 << x) > 0)
                        bw.write("1" + "\n");
                    else
                        bw.write("0" + "\n");

                    break;
                case "toggle":
                    x = Integer.parseInt(st.nextToken());
                    S ^= (1 << x);
                    break;
                case "all":
                    S = (1 << 21 ) -1;
                    break;
                case "empty":
                    S = 0;
                    break;
            }

        }
        bw.flush();
        bw.close();
        br.close();

    }
}
