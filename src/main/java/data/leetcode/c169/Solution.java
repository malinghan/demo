package data.leetcode.c169;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-09
 */
class Solution {
    public int majorityElement(int[] nums) {
        //二分？
        //投票
        //1. 哈希表
        //2. 排序取中位数
        //3. 随机取值
        //4. 分治法
        //5. 投票法

        //维护一个候选众数 candidate 和出现的次数 count
        //初始化时 candidate为任意值，count为0

        //遍历nums中所有元素，对每个元素i，在判断i之前，
        //如果count = 0, 说明众数和非众数互相抵消, 我们将i的值赋给candidate, candidate = nums[i]
        //然后判断i:
        //      if nums[i] == candidate , count++;
        //      if nums[i] != candidate, count--;
        // 遍历完成后 candidate就是整个数组的众数

        //例子： [7, 7, 5, 7, 5, 1 | 5, 7 | 5, 5, 7, 7 | 7, 7, 7, 7]
        //  candidate = null count = 0
        // i = 0 [count = 0] candidate = 7 count = 1
        // i = 1 candidate == nums[i] count = 2 candidate = nums[1]
        // i = 2  candidate != nums[i] count = 1 candidate = nums[1]
        // i = 3  candidate == nums[i]  count = 2 candidate = nums[1]
        // i = 4  candidate != nums[4]  count = 1 candidate = nums[1]
        // i = 5  candidate != nums[5]  count = 0 candidate = nums[1]
        // i = 6  [count = 0] candidate = nums[6]  count = 1 candidate = nums[6]
        // i = 7  candidate != nums[7]  count = 0 candidate = nums[6]
        // i = 8  [count = 0] candidate = nums[8]  count = 1 candidate = nums[8]
        // i = 9  candidate == nums[9]  count = 2 candidate = nums[8]
        // i = 10  candidate != nums[10]  count = 1 candidate = nums[8]
        // i = 11  candidate != nums[11]  count = 0 candidate = nums[8]
        // i = 12  [count = 0] candidate = nums[12]  count = 1 candidate = nums[12]
        // i = 13  candidate == nums[13]  count = 2 candidate = nums[12]
        // i = 14  candidate == nums[14]  count = 3 candidate = nums[12]
        // i = 15  candidate == nums[15]  count = 4 candidate = nums[12]
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
