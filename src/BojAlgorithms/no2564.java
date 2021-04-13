package BojAlgorithms;
/*
BOJ_2564 경비원

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no2564 {
    static int w, h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken()); // 가로
        h = Integer.parseInt(st.nextToken()); // 세로

        int areaSum = 2 *(w + h);

        int storeNum = Integer.parseInt(br.readLine());

        int[] position = new int[storeNum + 1];
        for(int i = 0; i < storeNum + 1; i++){
            st = new StringTokenizer(br.readLine());

            int d = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());

            switch (d) {
                case 1: // 북쪽
                    position[i] = dis;
                    break;
                case 2: // 남
                    position[i] = 2 * w + h - dis;
                    break;
                case 3: // 서
                    position[i] = areaSum - dis;
                    break;
                case 4: // 동
                    position[i] = w + dis;
                    break;
            }
        }

//        for(int i = 0; i < N + 1; i++){
//            for(int j = 0; j < M + 1; j++){
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("시작 x : " + stx + " 시작 y : " + sty);
        int res = 0;
        for(int i = 0; i < storeNum; i++){
            int tmp = Math.abs(position[storeNum] - position[i]);
            if (tmp > (w + h)) {
                res += areaSum - tmp;
            }else{
                res += tmp;
            }
        }
        System.out.println(res);
    }
}
