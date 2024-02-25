package data.leetcode.c503;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2023-12-09
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
 *
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 *
 * Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next
 * greater number for every element in nums.
 *
 * The next greater number of a number x is the first greater number to its traversing-order next in the array, which
 * means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.
 * Example 1:
 * Input: nums = [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number.
 * The second 1's next greater number needs to search circularly, which is also 2.
 *
 * Example 2:
 * Input: nums = [1,2,3,4,3]
 * Output: [2,3,4,-1,4]
 *
 */
public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] doubleNums = new int[2 * len];
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            doubleNums[i] = nums[i];
            doubleNums[i+len] = nums [i];
        }
        Stack<Integer> stack = new Stack<>();
        for (int j = 2 * len -1; j >= 0; j--) {
            while (!stack.isEmpty() && doubleNums[j] >= stack.peek()) {
                stack.pop();
            }
            if (j < len) {
                res[j] = stack.isEmpty() ? -1:stack.peek();
            }
            stack.push(doubleNums[j]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().nextGreaterElements(new int [] {1,2,3,4,3})));
    }
}
