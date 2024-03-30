package data.huaweiod.hj36;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String key = in.nextLine();
            String value = in.nextLine();
            //1. 去重并保留原始顺序
            key = trim(key);
            System.out.println(key.toString());
            //2. 将其放入前置，然后拼接后置
            String prev = key;
            for (char c = 'a' ; c <= 'z'; c = (char) (c+1)) {
                if (!prev.contains(c + "")) {
                     prev = prev + String.valueOf(c);
                }
            }
            System.out.println(prev.toString());
            //3. 根据2个字符串的关系，来加密
            StringBuilder res = new StringBuilder("");
            for (char v : value.toCharArray()) {
                int i = v - 'a';
                res.append(prev.charAt(i));
            }
            System.out.println(res.toString());
        }
    }

    static String trim(String key) {
        if (key == null || key.length() < 1) {
            return "";
        }
        Set<Character> hashSet = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < key.length(); i++) {
            if (!hashSet.contains(key.charAt(i))) {
                hashSet.add(key.charAt(i));
                sb.append(key.charAt(i));
            }
        }
        return sb.toString();
    }
}

// TRAILBLAZERS 
// 去重
// A B C D E F G H I J   K L M N O P Q R S T U V W X Y Z
// T R A I L B Z E S    C D F G H J K M N O P Q U V W X Y