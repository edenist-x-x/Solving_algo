package Others;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Intermediate01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++){
            int n = Integer.parseInt(br.readLine());
            char[][] map = new char[n][n];

            for(int i = 0; i < map.length; i++){
                for(int j = 0; j < map[i].length; j++){
                    map[i][j] = (char)br.read();
                }
            }

            for(int i = 0; i < map.length; i++){
                for(int j = 0; j < map[i].length; j++){
                    System.out.print(map[i][j] + " ");
                }
            }
        }
    }
}
