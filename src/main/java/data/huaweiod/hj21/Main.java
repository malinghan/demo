package data.huaweiod.hj21;

import java.util.Scanner;

import java.util.Map;
import java.util.HashMap;
// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String a = in.nextLine();
            Map<String, Integer>  map = new HashMap<>();
            map.put("abc", 2);
            map.put("def", 3);
            map.put("ghi", 4);
            map.put("jkl", 5);
            map.put("mno", 6);
            map.put("pqrs", 7);
            map.put("tuv", 8);
            map.put("wxyz", 9);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < a.length(); i++) {
                char c = a.charAt(i);
                if (Character.isDigit(c)) {
                    sb.append(c);
                } else if (c >= 'a' && c <= 'z') {
                    for (String key : map.keySet()) {
                        if (key.contains(c + "")) {
                            sb.append(map.get(key));
                            break;
                        }
                    }
                } else if (c >= 'A' && c <= 'Y') {
                    sb.append( (char) (Character.toLowerCase(c) +1));
                } else if (c == 'Z') {
                    sb.append("a");
                }
            }
            System.out.println( sb.toString());
        }
    }

    // 1 ---> 1
    // abc ---> 2
    // def ---> 3
    // ghi ---> 4
    // jkl ---> 5
    // mno ---> 6
    // pqrs ---> 7
    // tuv ---> 8
    // wxyz ---> 9
    // 0 ---> 0
}