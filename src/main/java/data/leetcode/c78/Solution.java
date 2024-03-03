package data.leetcode.c78;

import java.util.LinkedList;
import java.util.List;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-02
 */
public class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new LinkedList<>();
        backtrack(nums,  0);
        return res;
    }
    LinkedList<Integer> list  = new LinkedList<>();
    void backtrack(int[] nums , int index) {
        res.add(new LinkedList<>(list));
        if (index == nums.length) {
            return;
        }
        for(int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(nums, i+1);
            list.removeLast();
        }
    }
}