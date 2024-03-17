package data.huaweiod.hj5;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            output(str);
        }
    }

    public static void output(String str) {
        // A 10
        // B 11
        // C 12
        // D 13
        // E 14
        // F 15
        int i = 2;
        int total = 0;
        while(i < str.length()) {
            int num = 0;
            if (str.charAt(i) == 'A') {
                num = 10;
            } else if (str.charAt(i) == 'B') {
                num = 11;
            } else if (str.charAt(i) == 'C') {
                num = 12;
            } else if (str.charAt(i) == 'D') {
                num = 13;
            } else if (str.charAt(i) == 'E') {
                num = 14;
            } else if (str.charAt(i) == 'F') {
                num = 15;
            } else {
                num = Integer.valueOf(String.valueOf(str.charAt(i)));
            }
            total = total * 16 + num;
            i++;
        }
        System.out.println(total);
    }
}