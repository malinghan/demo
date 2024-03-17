package data.huaweiod.hj4;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-15
 */
import java.util.Scanner;
import java.lang.StringBuilder;
// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            outputSpilt(str);
        }
    }

    public static void outputSpilt(String str) {
        if (str == null || str.length() == 0) {
            return;
        }

        int len = str.length();
        for(int i = 0; i < len; i += 8) {
            if(i > len - 8) {
                StringBuilder sb = new StringBuilder(str.substring(i, len));
                for(int j = 0; j < i+ 8 - len; j++) {
                    sb.append("0");
                }
                System.out.println(sb);
            } else {
                System.out.println(str.substring(i,i+8));
            }
        }
    }
}