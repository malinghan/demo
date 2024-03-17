package data.huaweiod.hj14;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            int n = Integer.parseInt(in.nextLine());
            List<String> strs = new ArrayList<>();
            while(n > 0) {
                strs.add(in.nextLine());
                n--;
            }
            strs.stream().sorted().forEach(System.out::println);
        }
    }
}