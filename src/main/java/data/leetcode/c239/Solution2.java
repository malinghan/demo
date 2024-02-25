package data.leetcode.c239;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2023-12-08
 * 优先队列
 * 0 1 2 3 4  k=2
 */
public class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((o1, o2) -> o2.value - o1.value);
        int[] res = new int[n -k+1];
        for (int i = 0; i < n; i++) {
            if (i < k-1) {
                priorityQueue.offer(new Node(i, nums[i]));
            } else {
                priorityQueue.offer(new Node(i, nums[i]));
                res[i-k+1] = priorityQueue.peek().value;
                while (priorityQueue.peek() != null && i - k+1 >= priorityQueue.peek().index) {
                    priorityQueue.poll();
                }
            }
        }
        return res;
    }

    class Node {
        int index;
        int value;
        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Solution2    ().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
        System.out.println(Arrays.toString(new Solution2    ().maxSlidingWindow(new int[]{1,-1}, 1)));
    }
}
