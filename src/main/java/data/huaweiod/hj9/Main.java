package data.huaweiod.hj9;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            System.out.println(output(a));
        }
    }

    public static int output(int a) {
        int out = 0;
        Set<Integer> used = new HashSet<>();
        while (a != 0) {
            int num = a % 10;
            if (!used.contains(num)) {
                used.add(num);
                out = out * 10 + num;
            }
            a = a/10;
        }
        return out;
    }
}