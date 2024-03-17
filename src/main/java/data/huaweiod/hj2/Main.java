package data.huaweiod.hj2;

import java.util.Scanner;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-15
 * 描述
 * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
 *
 * 数据范围：
 * 1≤ str ≤1000
 *
 * 1≤n≤1000
 * 输入描述：
 * 第一行输入一个由字母、数字和空格组成的字符串，第二行输入一个字符（保证该字符不为空格）。
 *
 * 输出描述：
 * 输出输入字符串中含有该字符的个数。（不区分大小写字母）
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String a = in.nextLine();
            String b = in.nextLine();
            System.out.println(countWord(a, b));
        }
    }

    public static int countWord(String a, String b) {
        int n = a.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (b.equalsIgnoreCase(String.valueOf(a.charAt(i)))) {
                count++;
            }
        }
        return count;
    }

//    public static int countWord(String a, String b) {
//        int n = a.length();
//        int count = 0;
//        for (int i = 0; i < n; i++) {
//            if (b.toLowerCase().equals(String.valueOf(a.charAt(i)).toLowerCase())) {
//                count++;
//            }
//        }
//        return count;
//    }
}
