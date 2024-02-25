package data.leetcode.c239;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-25
 */
public class Solution4 {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0)
            return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1];
        int index = 0;

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // Remove elements outside the window
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // Remove smaller elements from the end
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }

            // Add current index to deque
            deque.offer(i);

            // Add maximum to result
            if (i >= k - 1) {
                result[index++] = nums[deque.peek()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        System.out.print("Sliding Window Maximum: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        // Output: [3, 3, 5, 5, 6, 7]
    }
}

