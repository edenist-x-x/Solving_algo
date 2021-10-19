package BojAlgorithms;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class no3190 {
    static int N,K,L;

    static int cnt=0;
    static int dir=1;

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};

    static int[][] map;
    static ArrayList<Point> list = new ArrayList<>();
    static ArrayList<Cmd> cmdlist = new ArrayList<>();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        K = Integer.parseInt(br.readLine());

        for(int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x - 1][y - 1] = 1;
        }

        L = Integer.parseInt(br.readLine());

        for(int l = 0; l < L; l++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            cmdlist.add(new Cmd(time,dir));
        }
        proc(0,0);
    }

    public static void proc(int i, int j) {
        while(true) {
            for(int k = 0; k< cmdlist.size(); k++) {
                int next = cmdlist.get(k).time;
                while(cnt < next) {
                    list.add(new Point(j,i));
                    int nx = i + dx[dir];
                    int ny = j + dy[dir];
                    if(!(0 <= nx && nx < N && 0 <= ny && ny < N)) {
                        System.out.println(cnt+1);
                        return;
                    }

                    if(check(nx,ny)) {
                        System.out.println(cnt+1);
                        return;
                    }else {
                        if(map[nx][ny]!=1) {
                            list.remove(0);
                        }else if(map[nx][ny]==1)
                            map[nx][ny]=0;

                        i = nx;
                        j = ny;
                        cnt++;
                    }
                }
                char d = cmdlist.get(k).dir;
                if(d == 'L') {
                    if(dir == 0)
                        dir = 3;
                    else
                        dir--;
                    dir %= 4;
                }else if(d == 'D') {
                    dir++;
                    dir %= 4;
                }

            }
            ///방향전환끝나고나서 돌아야함
            while(!check(i,j)) {
                int nx = j + dx[dir];
                int ny = i + dy[dir];
                if(!(0<=nx && nx<N && 0<=ny && ny<N)) {
                    System.out.println(cnt+1);
                    return;
                }
                if(check(nx , ny)) {
                    System.out.println(cnt+1);
                    return;
                }else {
                    if(map[nx][ny]!=1 && list.size()>0) {
                        list.remove(0);
                    }
                    i = ny;
                    j = nx;
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }

    public static boolean check(int i, int j) {
        for(int idx = 0; idx < list.size(); idx++)
            if(list.get(idx).x == j && list.get(idx).y == i)
                return true;
        return false;
    }

    public static class Cmd {
        int time;
        char dir;
        public Cmd(int t, char d) {
            this.time=t;
            this.dir=d;
        }
    }
}