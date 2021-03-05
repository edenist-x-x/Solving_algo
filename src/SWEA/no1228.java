package SWEA;

import java.util.*;

public class no1228 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);


        for(int tc = 1; tc <= 10; tc++){
            List<Integer> list = new LinkedList<>();
            int N = sc.nextInt();
            for(int i = 0; i < N; i++){
                list.add(sc.nextInt());
            }
            int cmdN = sc.nextInt();

            for(int i = 0; i < cmdN; i++){
                String cmd = sc.next();
                int x = sc.nextInt();
                int y = sc.nextInt();
                for(int j = 0; j < y; j++){
                    list.add(x, sc.nextInt());
                    x += 1;
                }
            }

            System.out.print("#" + tc + " ");
            for(int i = 0; i < 10; i++){
                System.out.print( list.get(i)+ " ");
            }
            System.out.println();
        }
    }
}
