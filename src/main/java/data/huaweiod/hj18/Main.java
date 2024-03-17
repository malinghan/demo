package data.huaweiod.hj18;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int cA = 0;
        int cB = 0;
        int cC = 0;
        int cD = 0;
        int cE = 0;
        int wr = 0;
        int pr = 0;
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            String ip = str.split("~")[0];
            String mask = str.split("~")[1];
            int ipFirst = getIpSeg(ip, 0);
            if (ipFirst == 0 || ipFirst == 127) {
                continue;
            }
            if (maskIsInValid(mask)) {
                wr++;
                continue;
            }
            if (ipIsInValid(ip)) {
                wr++;
                continue;
            }
            if (ipFirst >= 1 && ipFirst <= 126) {
                cA ++;
            }
            if (ipFirst >= 128 && ipFirst <= 191) {
                cB ++;
            }
            if (ipFirst >= 192 && ipFirst <= 223) {
                cC ++;
            }
            if (ipFirst >= 224 && ipFirst <= 239) {
                cD ++;
            }
            if (ipFirst >= 240 && ipFirst <= 255) {
                cE ++;
            }
            if (isIpPrivate(ip)) {
                pr++;
            }
        }
        System.out.println(cA + " " +
                cB + " " +
                cC + " " +
                cD + " " +
                cE + " " +
                wr + " " +
                pr);
    }

    public static  boolean ipIsInValid(String ip) {
        String[] ipArr = ip.split("\\.");
        if (ipArr.length != 4) {
            return true;
        }
        if (Integer.parseInt(ipArr[0]) >255 ||
                Integer.parseInt(ipArr[1]) >255 ||
                Integer.parseInt(ipArr[2]) >255 ||
                Integer.parseInt(ipArr[3]) >255 ) {
            return true;
        }
        return false;
    }

    public static  boolean maskIsInValid(String mask) {
        String[] maskArr = mask.split("\\.");
        if (maskArr.length != 4) {
            return true;
        }
        String maskBinary = toBinary(maskArr[0]) +
                toBinary(maskArr[1]) +
                toBinary(maskArr[2]) +
                toBinary(maskArr[3]);
        return !maskBinary.matches("[1]+[0]+");
    }

    //返回掩码
    public static String toBinary(String maskNum) {
        String numsBinary = Integer.toBinaryString(Integer.valueOf(maskNum));
        while(numsBinary.length() < 8) {
            numsBinary = "0" + numsBinary;
        }
        return numsBinary;
    }

    public static  boolean isIpPrivate(String ip) {
        return (getIpSeg(ip, 0) == 10) ||
                (getIpSeg(ip, 0) == 172
                        && getIpSeg(ip, 1) >= 16
                        && getIpSeg(ip, 1) <= 31) ||
                (getIpSeg(ip, 0) == 192 && getIpSeg(ip, 1) == 168);
    }

    public static int getIpSeg(String ip, int index) {
        String[] ipArr = ip.split("\\.");
        return Integer.valueOf(ipArr[index]);
    }
    // A
    // B
    // C
    // D
    // E
    // wrongIp or wrongHide
    // privateIp
}