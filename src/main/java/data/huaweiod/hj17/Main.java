package data.huaweiod.hj17;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int l = 0;
        int r = 0;
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            String[] arr = str.split(";");
            for (int i = 0 ; i < arr.length; i++) {
                String target = arr[i];
                int j = 0;
                if (target.length() == 0) {
                    continue;
                }
                if (validDir(target.charAt(j)) == '&' 
                || validNumber(target) == -1) {
                    continue;
                } 
                char c = validDir(target.charAt(j));
                int num = validNumber(target);
                if (c == 'A') {
                    l -= num; 
                } else  if (c == 'D') {
                    l += num; 
                } else  if (c == 'W') {
                    r += num; 
                } else {
                    r -= num; 
                }
            }
            System.out.println(l+","+r);
        }
    }

   public static char validDir(char c) {
        if (c == 'A' || c == 'S' || c == 'W' || c == 'D') {
            return c;
        } else {
            return '&';
        }
    }

    public static int validNumber(String target) {
        int number = 0;
       for (int i = 1; i < target.length(); i++) {
           if (!Character.isDigit(target.charAt(i))) {
                 return -1;
           }
           number = number * 10 + target.charAt(i) - '0';
       }
       return number;
    }
}