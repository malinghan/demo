package data.huaweiod.hj29;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String en = in.nextLine();
            String de = in.nextLine();
            encode(en);
            decode(de);
        }
    }

    static void encode(String str) {
        StringBuilder sb = new StringBuilder();
        for(char c: str.toCharArray()) {
            if(c == '9') {
                sb.append("0");
            } else if (Character.isDigit(c)) {
                sb.append((char)(c + 1));
            } else if (Character.isAlphabetic(c)) {
                if (c >= 'a' && c < 'z') {
                    sb.append((char)(c - 'a' + 'A' + 1));
                } else if (c >= 'A' && c < 'Z') {
                    sb.append((char)(c - 'A' + 'a' + 1));
                } else if (c == 'z') {
                    sb.append('A');
                } else if (c == 'Z') {
                    sb.append('a');
                } else {
                    sb.append(c);
                }
            } else {
                sb.append(c);
            }
        }
        System.out.println(sb);
    }

    static void decode(String str) {
        StringBuilder sb = new StringBuilder();
        for(char c: str.toCharArray()) {
            if(c == '0') {
                sb.append("9");
            } else if (Character.isDigit(c)) {
                sb.append((char)(c - 1));
            } else if (Character.isAlphabetic(c)) {
                if (c > 'a' && c <= 'z') {
                    sb.append((char)(Character.toUpperCase(c)-1));
                } else if (c > 'A' && c <= 'Z') {
                    sb.append((char)(Character.toLowerCase(c)-1));
                } else if (c == 'a') {
                    sb.append('Z');
                } else if (c == 'A') {
                    sb.append('z');
                }
            } else {
                sb.append(c);
            }
        }
        System.out.println(sb);
    }
}
// 加密方法为：
//对输入的字符串进行加解密，并输出。
// 当内容是英文字母时
 // 用该英文字母的后一个字母替换,同时字母变换大小写 => 如字母a时则替换为B；字母Z时则替换为a
 //当内容是数字时
 // 则把该数字加1，如0替换1，1替换2，9替换0
 //其他字符不做变化

 //解密方法为加密的逆过程。
 // 保证输入的字符串都是只由大小写字母或者数字组成

