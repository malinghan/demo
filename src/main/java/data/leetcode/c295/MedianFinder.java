package data.leetcode.c295;

import java.util.PriorityQueue;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-03
 */
public class MedianFinder {
    PriorityQueue<Integer> A, B;
    public MedianFinder() {
        A = new PriorityQueue<>();  //小顶堆，保存较大的一半
        B = new PriorityQueue<>( (o1, o2) -> (o2 - o1)); //大顶堆，保存较小的一半
    }

    public void addNum(int num) {
        //设A，B的数量分别是m, n
        if(A.size() != B.size()) {
            A.add(num);
            B.add(A.poll());
        } else {
            //如果是偶数的话, 需要向A添加一个元素，让A可以多保存一个
            //将新元素插入B, 再挑选大个子到A
            B.add(num); // n+1;
            A.add(B.poll()); // n-1 m+1;
            // m+1 , n不变
        }
    }
    public double findMedian() {
        return A.size() != B.size() ? A.peek(): (A.peek() + B.peek()) / 2.0;
    }
}
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */