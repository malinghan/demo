package data.leetcode.c31;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-09
 */
class Solution {
    public void nextPermutation(int[] nums) {
        //必须 原地 修改，只允许使用额外常数空间。
        //下一个排列规则
        // 1,2,3 -> 1,3,2
        // 2,3,1 -> 3,1,2
        // 3,2,1 -> 1,2,3
        //从小到大排最小，从大到小排最大
        //算法思路:
        //原则1(比前数大): 将后面的大数与前面的小数交换
        //原则2(增幅最小):
        //   a. 后面的数优先交换
        //   b. 将一个尽可能小的[大数]，与前面的小数交换 [如果他是最小的数，往前进一步]
        //   c. 交换之后，将后面的数重置为升序。因为升序是最小的排列

        //算法实现:
        //1. i = n-2; i--; 查找相邻降序(i,j) nums[i] >= nums[i+1]  [....2, 3,2,1] , 找到第一个升序
        //2. j = n -1; j--; 查找比nums[i]尽可能小的[大数], j
        //3. swap: nums[i], nums[j]  [....3,2,2,1]   nums[i] = 3 nums[j]
        //4. 将后面的数(j, n-1)，按从小到大排序, 目前是从大到小，也就是需要翻转

        //5. bad case: 整个nums是降序排列，=> 省去swap, 直接reverse
        //------------------

        int n = nums.length;
        int i = n-2;
        while(i >=0 && nums[i] >= nums[i+1]) {
            i--;
        }
        if (i >= 0) {
            int j = n-1;
            //[1,5,1,1]
            while(j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i , j);
        }
        reverse(nums, i+1, n-1);
    }

    void swap(int[] nums, int i , int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    void reverse(int[] nums, int l, int r) {
        while(l < r) {
            swap(nums, l ,r);
            l++;
            r--;
        }
    }
}
