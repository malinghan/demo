package data.leetcode.c169;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-09
 */
class Solution1 {
    public int majorityElement(int[] nums) {
        //二分？
        //投票
        //1. 哈希表
        //2. 排序取中位数
        //3. 随机取值
        //4. 分治法
        //5. 投票法
        int count = 1;
        int candidate = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1:-1;
        }
        return candidate;
    }
}
