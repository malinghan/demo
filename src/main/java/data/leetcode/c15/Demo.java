package data.leetcode.c15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 思路：三指针移动
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2023-11-29
 * 本题的难点在于如何去除重复解
 */
public class Demo {
    //给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，
    // 同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
    //你返回所有和为 0 且不重复的三元组。
    //注意：答案中不可以包含重复的三元组。
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return null;
        }
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length-3; i++) {
            if (nums[i] > 0) {
                return res;
            }
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i+1, k = nums.length -1;
            while(j < k) {
                if (nums[j] + nums[k] + nums[i] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                    while( j < k && nums[j] == nums[j+1]) {
                        j++;
                    }
                    while(j < k && nums[k] == nums[k-1]) {
                        k--;
                    }
                    j++;
                    k--;
                } else if (nums[j] + nums[k]+nums[i] < 0) {
                    j++;
                } else {
                    k--;
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println( new Demo().threeSum(new int[]{-1,-1,0,2}));
    }
}
