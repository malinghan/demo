package data.huaweiod.hj1;

import java.util.Scanner;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-15
 * 描述
 * 计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。（注：字符串末尾不以空格为结尾）
 * 输入描述：
 * 输入一行，代表要计算的字符串，非空，长度小于5000。
 *
 * 输出描述：
 * 输出一个整数，表示输入字符串最后一个单词的长度。
 */
public class Main {

    // 注意类名必须为 Main, 不要有任何 package xxx 信息
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        // hasNext是检查是否有非空字符。
        // hasNextLine是检查输入中是否还有linePattern
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            str.split("");
            System.out.println(getLastWord(str));
        }
    }

   public static Integer getLastWord(String str) {
        int n = str.length();
        int i = n-1;
        for ( ;i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                break;
            }
        }
        return n - i-1;
    }

    public static Integer getLastWord1(String str) {
        int n = str.length();
        int count = 0;
        for ( int i = n-1; i >= 0; i--) {
            if (str.charAt(i) == ' ') {
                break;
            }
            count++;
        }
        return count;
    }
}
