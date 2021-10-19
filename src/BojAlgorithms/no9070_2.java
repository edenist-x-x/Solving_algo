package BojAlgorithms;

import java.io.*;
import java.util.StringTokenizer;

public class no9070_2 {

    static int[][] arr=new int[3][3];

    static void reverse(int num) {
        for(int i=0;i<3;i++) {
            if(num<3) //가로
                arr[num][i]=1-arr[num][i];
            else if(num<6)//세로
                arr[i][num-3]=1-arr[i][num-3];
            else if(num==6){//왼쪽 위에서 오른쪽 아래방향 대각선
                arr[i][i]=1-arr[i][i];
            }else {//오른쪽 위에서 왼쪽 아래방향 대각선
                arr[i][2-i]=1-arr[i][2-i];
            }
        }
    }

    static boolean verify() {
        int first=arr[0][0];
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                if(arr[i][j]!=first) {
                    return false;
                }
            }
        }
        return true;
    }

    static int dfs(int idx,int successCount,int preSelect) {


        if(verify())
            return idx;

        for(int i=preSelect+1;i<8;i++) {

            if(i==preSelect)
                continue;

            reverse(i);
            int tmp=dfs(idx+1,successCount,i);
            if(tmp!=-1) {
                if(successCount==-1)
                    successCount=tmp;
                else
                    successCount=Math.min(successCount, tmp);
            }
            reverse(i);

        }
        return successCount;
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while(t-->0) {

            for(int i = 0; i < 3; i++) {
                st = new StringTokenizer(br.readLine());

                for(int j=0;j<3;j++) {
                    String str = st.nextToken();
                    if(str.equals("H"))
                        arr[i][j]=0;
                    else
                        arr[i][j]=1;
                }
            }

            int ans=dfs(0,-1,-1);
            sb.append(ans).append("\n");
        }

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}