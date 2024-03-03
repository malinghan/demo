package data.leetcode.c152;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2023-12-09
 */
public class Solution01 {
    //输入: nums = [2,3,-2,4]
    //输出: 6
    //1 <= nums.length <= 2 * 104
    //-10 <= nums[i] <= 10
    //nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxDp = nums[0];
        int minDp = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            int tempMax = maxDp;
            int tempMin = minDp;
            maxDp = Math.max(Math.max(tempMax * nums[i], tempMin * nums[i]), nums[i]);
            minDp = Math.min(Math.min(tempMax * nums[i], tempMin * nums[i]), nums[i]);
            max = Math.max(maxDp, max);
        }
        return max;
    }
    //nums  -2 0 -1
    //maxDp -2 0 1
    //minDp -2

    public static void main(String[] args) {
        //        System.out.println(new Trie().maxProduct(new int[] {2,3,-2,4}));
        System.out.println(new Solution01().maxProduct(new int[] {-2,0, -1}));
    }
}
