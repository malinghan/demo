package data.huaweiod.hj11;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            String str = String.valueOf(a);
            System.out.println(reverse(str));
        }
    }

    public static String reverse(String str) {
        StringBuilder sb = new StringBuilder(str + "");
        return sb.reverse().toString();
    }

    public static String reverse1(String str) {
         char[] arr = str.toCharArray();
           int r = str.length() -1;
           int l = 0;
           while(l < r) {
                char c = arr[r];
                arr[r] = arr[l];
                arr[l] = c;
                l++;
                r--;
           }
           return String.valueOf(arr);
    }
}