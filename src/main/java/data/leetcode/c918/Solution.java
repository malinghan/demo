package data.leetcode.c918;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2023-12-09
 * 给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。
 *
 * 环形数组 意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个元素是 nums[(i - 1 + n) % n] 。
 *
 * 子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不存在 i <= k1, k2 <= j 其中 k1 % n == k2 %
 * n 。
 *
 * 示例 1：
 *
 * 输入：nums = [1,-2,3,-2]
 * 输出：3
 * 解释：从子数组 [3] 得到最大和 3
 * 示例 2：
 *
 * 输入：nums = [5,-3,5]
 * 输出：10
 * 解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
 * 示例 3：
 *
 * 输入：nums = [3,-2,2,-3]
 * 输出：3
 * 解释：从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3
 */
public class Solution {

    public int maxSubarraySumCircular(int[] nums) {
        int  n = nums.length;
        int[] dp = new int[n];
        int[] dpMin = new int[n];
        dp[0] = nums[0];
        int max = nums[0];
        dpMin[0] = nums[0];
        int min =  nums[0];
        int sum = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            dpMin[i] = Math.min(dpMin[i-1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
            min = Math.min(dpMin[i], min);
            sum += nums[i];
        }
        //当 minS=sum(nums)时，最小子数组可以是整个数组？  例如 1 ， -1 ，1
        max =  sum - min != 0 ? Math.max(max, sum - min) : max;
        //    max =  Math.max(max, sum - min);
        // -2 -2 -1 -2 max = -1 min = -7  sum = -7   Math.max(max, sum - min) = Math(-1, 0) = 0 不符合条件
        // if:  max < 0 , 数组中所有元素都 < 0, 则min 一定包含所有元素，则一定有 sum = min,  max = sum - min
        return max;
    }
    // 5 -3 5 5 -3 5

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubarraySumCircular(new int[]{5,-3,5}));
    }

}
