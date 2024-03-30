package data.huaweiod.hj26;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String s= in.nextLine();
            sort(s);
        }
    }

    //case1: 排序
    //case2: 按输入顺序排列[大小写同时存在]
    //case3: 保持原位[非英文]

    //把英文字母全部提取出来，原地排序
    //再把非英文字母插入进去

    public static void sort(String str) {
          StringBuilder sb = new StringBuilder();
          for (char c: str.toCharArray()) {
              if (Character.isAlphabetic(c)) {
                  sb.append(c);
              }
          }
         char[] arr = sb.toString().toCharArray();
         quickSort(arr , 0 , arr.length -1);
         int j = 0;
         StringBuilder res = new StringBuilder();
         for (int i = 0; i < str.length(); i++) {
             if (Character.isAlphabetic(str.charAt(i))) {
                     res.append(arr[j]);
                     j++;
             } else {
                res.append(str.charAt(i));
             }
         }
         System.out.println(res.toString()); 
    }

    static void quickSort(char[] arr, int l , int r) {
         if (l > r) {
            return;
         } 
         int idx =  helper(arr, l, r);
         quickSort(arr, l , idx-1);
         quickSort(arr, idx+1, r);
    }

    static int helper(char[] arr, int l , int r) {
          char  k = arr[r];
          int p1 = l ;
          int p2 = r-1;
          while(p1 <= p2) {
            if (Character.toLowerCase(arr[p1]) < Character.toLowerCase(k)) {
                p1++;
            } else if (Character.toLowerCase(arr[p2])  > Character.toLowerCase(k)) {
                p2--;
            } else {
                char curr = arr[p1];
                arr[p1] = arr[p2];
                arr[p2] = curr;
                p1++;
                p2--;
            }
          }
          //swap k and p1
          arr[r] = arr[p1];
          arr[p1] = k;
          return p1;
    }

    
}