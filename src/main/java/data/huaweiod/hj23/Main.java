package data.huaweiod.hj23;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String a = in.nextLine();
            Map<Character, Integer> map = new HashMap<>();
            for(char c : a.toCharArray()) {
                map.putIfAbsent(c, 0);
                //这里的函数用错了，fk
                map.put(c, map.get(c)+1);
            }
            int min = Collections.min(map.values());
            System.out.println(min);
            StringBuilder sb = new StringBuilder();
            for(char c : a.toCharArray()) {
                if (map.get(c) != min) {
                    sb.append(c);
                }
            }
            System.out.println(sb.toString());
        }

        //思路：先用map统计wordCount
        //再循环判断最小值
        //再循环判断哪一个最小值，即次数最少的字符
        //用空字符串替换掉最小的字符
    }
}