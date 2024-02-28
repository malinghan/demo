package data.leetcode.c215;

import java.util.PriorityQueue;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-28
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        //优先队列
        PriorityQueue<Integer> queue = new PriorityQueue(k);
        for(int i = 0 ; i < nums.length; i++) {
            if (i >= k) {
                if(nums[i] >= queue.peek()) {
                    queue.poll();
                    queue.offer(nums[i]);
                }
            } else {
                queue.offer(nums[i]);
            }
        }
        return queue.peek();
    }
}