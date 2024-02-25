package data.leetcode.c239;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-25
 */
public class Solution3 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
        //输出：[3,3,5,5,6,7]
        //[1  3  -1] -3  5  3  6  7       3
        //        1 [3  -1  -3] 5  3  6  7       3
        //        1  3 [-1  -3  5] 3  6  7       5
        //        1  3  -1 [-3  5  3] 6  7       5
        //        1  3  -1  -3 [5  3  6] 7       6
        //        1  3  -1  -3  5 [3  6  7]      7
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[nums.length - k +1];
        //index标记最大值位置
        //window slide
        for(int j = 0 ; j < nums.length;  j++) {
            //窗口判断逻辑: 移除失效的值
            while (!deque.isEmpty() && deque.peek() < j -k+1) {
                deque.removeFirst();
//                deque.pollFirst();
//                deque.poll();
            }
            //remove逻辑:队列中的元素保持单调递减，且队头元素在窗口内
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[j]) {
//                while(!deque.isEmpty() && nums[deque.peek()] < nums[j]) {
//                deque.removeFirst();
                deque.pollLast();
            }
//            deque.addLast(j);
            deque.offer(j);
            //add逻辑
            if( j >= k-1) {
                res[j-k+1] = nums[deque.peek()];
            }
        }
        return res;
    }
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Solution3().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
        System.out.println(Arrays.toString(new Solution3().maxSlidingWindow(new int[]{1,3,1,2,0,5}, 3)));
        //1,3,1,2,0,5  k= 3
        //deque: 1,3,1
        //deque: 1,2    3,1
        //deque: 3,4    2,0
        //3
    }
}
