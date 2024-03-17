package data.huaweiod.hj15;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int n = 32;
            int count = 0;
            while(n > 0) {
                if ( (a & 1) == 1) {
                   count++;
                }
                a = a >>> 1;
                n--;
            }
            System.out.println(count);
        }
    }
}