package data.leetcode.c239;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-25
 */
public class Solution5 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //从大到小
        PriorityQueue<MyNode> queue = new PriorityQueue<>((o1, o2) -> o2.value - o1.value);
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            queue.offer(new MyNode(i, nums[i]));
            //最大值由queue，维护, 还需要窗口维护
            if (i >= k-1) {
                result[i-k+1] = queue.peek().value;
                while(!queue.isEmpty() && queue.peek().index <= i-k+1) {
                    queue.poll();
                }
            }
        }
        return result;
    }

    class MyNode {
        int index;
        int value;
        public MyNode(int index,int value){
            this.value = value;
            this.index = index;
        }
    }
    public static void main(String[] args) {
        //        System.out.println(Arrays.toString(new Solution5().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
        System.out.println(Arrays.toString(new Solution5().maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3)));
        //1,3,1,2,0,5  k= 3
        //deque: 1,3,1
        //deque: 1,2    3,1
        //deque: 3,4    2,0
        //3
    }
}
