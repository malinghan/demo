package data.huaweiod.hj6;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            System.out.println(getResult(a));
        }
    }

    public static String getResult(Integer num) {
        int k = 2;
        StringBuilder sb = new StringBuilder();
         while(k <= num) {
        while(num != 1) {
            while (num % k == 0) {
                    num = num / k;
                    sb.append(k).append(" ");
            }
            break;    
        }
        k++;
        }
        return sb.toString();
    }
}