package data.huaweiod.hj25;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Map;
import java.util.*;
// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            int iN = in.nextInt();
            int[] I = new int[iN];
            for (int i = 0; i < iN; i++) {
                I[i] = in.nextInt();
            }
            int rN = in.nextInt();
            int[] R = new int[rN];
            for (int i = 0; i < rN; i++) {
                R[i] = in.nextInt();
            }
            Arrays.sort(R);
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0 ; i < rN; i++) {
                if (i > 0 && R[i] == R[i - 1]) {
                    continue;
                }
                String r = String.valueOf(R[i]);
                for (int j = 0; j < iN; j++) {
                    String s = String.valueOf(I[j]);
                    if (s.contains(r)) {
                        map.putIfAbsent(i, new ArrayList<>());
                        map.get(i).add(j);
                    }
                }
            }
            int wordCount = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0 ; i < rN; i++) {
                if (i > 0 && R[i] == R[i - 1]) {
                    continue;
                }
                if (map.containsKey(i)) {
                    int size = map.get(i).size();
                    sb.append(R[i]).append(" ");
                    wordCount++;
                    sb.append(size).append(" ");
                    wordCount++;
                    for(int x :map.get(i)) {
                        sb.append(x).append(" ");
                        sb.append(I[x]).append(" ");
                        wordCount += 2;
                    }
                }
            }
            String res = wordCount + " " + sb.toString();
            System.out.println(res);
        }
    }

    // R 5,[6,3,6,3,0]
    // I 15,[123,456,786,453,46,7,5,3,665,453456,745,456,786,453,123]
    // 从R一个元素，找到满足条件的I
    // 条件： I[i]需要包含R[j]中的数字

    //输出：
    //1. 输出R[i]
    //2. 输出 满足条件I的个数
    //3. 初始 满足条件I的所有元素下标
    //4. 输出 I[i]

    //I 15 [123 456 786 453 46 7 5 3 665 453456  745 456 786 453 123]
    //R 5 [6 3 6 3 0] => 0 3 3  6 6
    // 30
    // 3
    // 6 => 0 123
    //      3 453
    //       7 3
    //       9 453456
    //      13 453
    //       14 123
    // 6
    // 7 => 1 456
    //      2 786
    //      4 46
    //      8 665
    //     9  453456
    //      11 456
    //     12 786

}