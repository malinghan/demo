package data.huaweiod.hj14;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-17
 */
// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            int n = Integer.valueOf(in.nextLine());
            List<String> strs = new ArrayList<>();
            while(n > 0) {
                strs.add(in.nextLine());
                n--;
            }
            getSortedArr(strs);
        }
    }

    static void getSortedArr(List<String> strs) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        for(int  i = 0 ; i < strs.size(); i++) {
            pq.offer(strs.get(i));
        }
        while(!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}