package BojAlgorithms;


public class no4673 {
    public static void main(String[] args) {
        int[] arr = new int[10001];

        for(int i = 1; i < arr.length; i++){
            int result = dNum(i);
            if (result <= 10000) {
                arr[result] = 1;
            }
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != 1) {
                System.out.println(i);
            }
        }

    }
    public static int dNum(int val) {
        int result = val;

        while (val > 0) {
            result += val % 10;
            val /= 10;
        }
        return result;
    }
}