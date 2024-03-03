package data.leetcode.c152;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2023-12-09
 */
public class Solution {
    //输入: nums = [2,3,-2,4]
    //输出: 6
    //1 <= nums.length <= 2 * 104
    //-10 <= nums[i] <= 10
    //nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数
    public int maxProduct(int[] nums) {
       int n = nums.length;
       int[] maxDp = new int[n];
       int[] minDp = new int[n];
       maxDp[0] = nums[0];
       minDp[0] = nums[0];
       int max = nums[0];
       for (int i = 1; i < n; i++) {
            maxDp[i] = Math.max(Math.max(maxDp[i-1] * nums[i], minDp[i-1] * nums[i]), nums[i]);
            minDp[i] = Math.min(Math.min(maxDp[i-1] * nums[i], minDp[i-1] * nums[i]), nums[i]);
            max = Math.max(maxDp[i], max);
       }
       return max;
    }
    //nums  -2 0 -1
    //maxDp -2 0 1
    //minDp -2

    public static void main(String[] args) {
//        System.out.println(new Trie().maxProduct(new int[] {2,3,-2,4}));
        System.out.println(new Solution().maxProduct(new int[] {-2,0, -1}));
    }
}
