package data.huaweiod.hj3;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-15
 */
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

import  java.util.List;
import  java.util.ArrayList;
import  java.util.Collections;
import java.util.TreeSet;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        List<Integer> arr = new ArrayList<>();
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            int n = Integer.parseInt(in.nextLine());
            while(n > 0) {
                arr.add(Integer.valueOf(in.nextLine()));
                n --;
            }
        }
        sort(arr);
    }

    public static void sort(List<Integer> arr) {
        Collections.sort(arr);
        System.out.println(arr.get(0));
        for(int i = 1 ; i < arr.size(); i++) {
            if (!Objects.equals(arr.get(i), arr.get(i - 1))) {
                System.out.println(arr.get(i));
            }
        }
    }

    public static void sort1(List<Integer> arr) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (Integer integer : arr) {
            treeSet.add(integer);
        }
        Iterator<Integer> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
