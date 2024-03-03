package data.leetcode.c78;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-03
 */
public class Solution2 {
    List<List<Integer>> res;
    Set<Integer> visited;
    List<Integer> list  = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        visited = new HashSet<>();
        backtrack(nums, 0);
        return res;
    }
    void backtrack(int[] nums ,int start) {
        res.add(new ArrayList<>(list));
        for(int i = start; i < nums.length; i++) {
            if (visited.contains(i)) {
                continue;
            }
            // if (i > start && nums[i] == nums[i-1]) {
            //     continue;
            // }
            list.add(nums[i]);
            visited.add(i);
            backtrack(nums, i+1);
            visited.remove(i);
            list.remove(list.size() -1);
        }
    }
}
