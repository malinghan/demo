package data.leetcode.c75;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-09
 */
public class Solution2 {
    public void sortColors(int[] nums) {
        //把0往左移动，2往右移动，1不管
        int n = nums.length;
        if (n  == 1) {
            return;
        }
        int p = 0;
        int q = n-1;
        for (int i = 0 ; i < n; i++) {
            //i移动到q处，说明交换完成
            if(i > q) {
                break;
            }
            //当我们找到 2时，我们需要不断地将其与 nums[p2]交换，使得新的 nums[i] 不为2
            while(i <= q && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[q];
                nums[q] = temp;
                q--;
            }
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p];
                nums[p] = temp;
                p++;
            }
        }
    }
}