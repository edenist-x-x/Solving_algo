package BojAlgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class no19945 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String str = Integer.toString(n);
        String a;

        int i = 0;
        String[] strs = str.split(" ");
        List<String> list = new ArrayList<>();

        if(n == 0){
            System.out.println("1");
        }
        else{
            a = Integer.toBinaryString(Integer.parseInt(str));
            list.add(strs[Integer.parseInt(a)]);

            for(i = 0; i < list.size(); i++){
                if(list.get(i).equals("0") && list.get(i+1).equals(list.get(i)) ){
                    list.remove(i);
                }
            }
            System.out.println(list.size());
        }
    }
}
