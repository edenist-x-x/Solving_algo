package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class no1974 {
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++){
            map = new int[9][9];
            boolean isOk = true;
            for(int row = 0; row < 9; row++){
                String str = br.readLine();
                st = new StringTokenizer(str, " ");
                for(int col = 0; col < 9; col++){
                    map[row][col] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i = 0; i < 9; i ++){ // 행에 1~9까지 있는지 확인
                int[] nums = new int[9];
                for(int j = 0; j < 9; j++){
                    nums[map[i][j] - 1] ++; //
                }
                for(int n = 0; n < 9; n++){
                    if(nums[n] == 0){
                        isOk = false;
                        break;
                    }
                }
            }
            for(int i = 0; i < 9; i++){ // 열에 1~9까지 있는지 확인
                int[] nums = new int[9];
                for(int j = 0; j < 9; j++){
                    nums[map[j][i] - 1] ++;
                }
                for(int n = 0; n < 9; n++){
                    if (nums[n] == 0) {
                        isOk = false;
                        break;
                    }
                }
            }
            for (int i = 0; i <= 6; i += 3) {
                for (int j = 0; j <= 6; j += 3) {
                    int[] nums = new int[9];

                    for(int k = i; k < i + 3; k++){
                        for(int l = j; l < j + 3; l++){
                            nums[(map[k][l] - 1)]++;
                        }
                    }
                    for(int n = 0; n < 9; n++){
                        if (nums[n] == 0) {
                            isOk = false;
                            break;
                        }
                    }
                }
            }
            if(!isOk){
                System.out.println("#" + tc + " 0");
            }else
                System.out.println("#" + tc + " 1");
        }

    }
}
