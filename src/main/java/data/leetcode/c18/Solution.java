package data.leetcode.c18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2023-12-01
 * 如何保证呢？
 */
public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len  = nums.length;
        //1 2 3 4
        //0 1 2 3
        //len-3
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < len-3; i++) {
            if (i >0 && nums[i] == nums[i-1]) {
                continue;
            }
            //避免整型溢出
            if (0L + nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) {
                return res;
            }
            if (0L + nums[i] + nums[len-1] + nums[len-2] + nums[len-3] < target) {
                continue;
            }
            for (int j = i+1; j < len-2; j++) {
                if (j >i+1 && nums[j] == nums[j-1]) {
                    continue;
                }
                int l = j+1;
                int r = len -1;
                while (l <r) {
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l+1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r-1]) {
                            r--;
                        }
                        l++;
                        r--;
                    } else if (sum < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
