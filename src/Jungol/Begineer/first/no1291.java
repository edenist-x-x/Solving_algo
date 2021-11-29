package Jungol.Begineer.first;

import java.io.*;
import java.util.StringTokenizer;

/*
NO1291_구구단
 */
public class no1291 {
        static int s, e;
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st;
//        Scanner sc = new Scanner(System.in);

            boolean flag = false;

            while(!flag){
                st = new StringTokenizer(br.readLine());

                s = Integer.parseInt(st.nextToken());
                e = Integer.parseInt(st.nextToken());

                if(s >= 2 && s <= 9 && e <= 9 && e >= 2 ){
                    if(s > e){
                        for(int i = 0; i < 9; i++){
                            for(int j = s; j >= e; j--){
                                int num = j * (i + 1);
                                System.out.print(j + " * " + (i + 1) + " = ");
                                System.out.printf("%2d", num);
                                System.out.print("   ");
                            }
                            System.out.println();
                        }
                    } else if(s < e){
                        for(int i = 0; i < 9; i++){
                            for(int j = s; j <= e; j++){
                                int num = j * (i + 1);
                                System.out.print(j + " * " + (i + 1) + " = ");
                                System.out.printf("%2d", num);
                                System.out.print("   ");
                            }
                            System.out.println();
                        }
                    }
                    else {
                        for(int i = 0; i < 9; i++){
                            int num = s * (i + 1);
                            System.out.print(s + " * " + (i + 1) + " = ");
                            System.out.printf("%2d", num);
                            System.out.print("   ");
                            System.out.println();
                        }
                    }
                    flag = true;
                }
                else System.out.println("INPUT ERROR!");
            }
        }
    }

