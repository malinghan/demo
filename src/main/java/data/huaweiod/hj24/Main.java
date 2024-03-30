package data.huaweiod.hj24;

import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int  i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int[] left = new int[n];
            int[] right = new int[n];
            left[0] = 1;
            right[n-1] = 1;
            
            for(int  i = 1; i < n; i++) {
                left[i] = 1;
                int j = 0;
                 while(j < i) {
                    if (arr[i] > arr[j]) {
                        left[i] = Math.max(left[j] +1, left[i]);
                    }
                    j++;
                 }
            }

            for(int  i = n-1; i >= 0; i--) {
                right[i] = 1;
                int j = n-1;
                 while(j > i) {
                    if (arr[i] > arr[j]) {
                        right[i] = Math.max(right[j] +1, right[i]);
                    }
                    j--;
                 }
            }
            int[] res = new int[n];
            int max = 0;
            for(int  i = 1; i < n; i++) {
                res[i] = left[i] + right[i] -1;
                max = Math.max(res[i],  max);
            }
            System.out.println(n - max);
        }
    }

    //求需要剔除多少个元素，才能形成波浪序列
    // => 可以形成波浪序列的最长长度为多少，设定为 n, 则 ans = len - n;
    //如何求可以形成波浪序列的最长长度？
        // 动态规划，类比与最长递增子序列,步骤如下:
        // 1. 求 left[i],表示i左侧的最长上升子序列长度
        // 2. 求 right[i],表示i右侧的最长下降子序列长度
        // 3. dp[i] = left[i] + right[i] -1


}