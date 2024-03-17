package data.huaweiod.hj8;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-15
 */
import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;
// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int len = n;
            Map<Integer, Integer> map = new TreeMap<>();
            while(n > 0) {
                int key = in.nextInt();
                int value  = in.nextInt();
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + value);
                } else {
                    map.put(key, value);
                }
                n--;
            }
            output(map);
        }
    }

    public static void output(Map<Integer, Integer> map) {
        map.entrySet().forEach(entry ->
                System.out.println(entry.getKey() + " " + entry.getValue()));
    }
}