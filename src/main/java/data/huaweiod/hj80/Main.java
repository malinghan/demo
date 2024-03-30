package data.huaweiod.hj80;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n1 = in.nextInt();
            int[] arr1 = new int[n1];
            for(int i = 0; i < n1; i++) {
                arr1[i] = in.nextInt();
            }
            int n2 = in.nextInt();
            int[] arr2 = new int[n2];
            for(int i = 0; i < n2; i++) {
                arr2[i] = in.nextInt();
            }
            List<Integer> res = merge(arr1, arr2);
            for(Integer r : res) {
                System.out.print(r);
            }
            
        }
    }

    public static List<Integer> merge(int[] arr1, int[] arr2) {
        int i = 0;
        int j = 0;
        List<Integer> res = new ArrayList<>();
        while (i < arr1.length && j < arr2.length) {
            if (i > 0 && arr1[i] == arr1[i-1]) {
                i++;
                continue;
            } 
            if (j > 0 && arr2[j] == arr2[j-1]) {
                j++;
                continue;
            } 
            if (arr1[i] == arr2[j]) {
                 j++;
            } else if (arr1[i] < arr2[j]) {
                res.add(arr1[i]);
                i++;
            } else {
                res.add(arr2[j]);
                j++;
            }
        }
        while (i < arr1.length) {
            if(i == 0 || arr1[i] != arr1[i-1]) {
                res.add(arr1[i]);
            }
            i++;
        }
        while (j < arr2.length) {
            if(j  ==  0 || arr2[j] != arr2[j-1]) {
                res.add(arr2[j]);
            }
            j++;
        }
        return res;
    }
}