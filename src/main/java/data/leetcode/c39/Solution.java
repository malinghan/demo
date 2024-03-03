package data.leetcode.c39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-03
 * 可以重复访问当前元素，但不能访问当前元素以前的元素
 */
class Solution {
    List<List<Integer>> res;
    List<Integer> list;
    List<Integer> visited;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        visited = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target);
        return res;
    }
    void backtrack(int[] candidates, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < candidates.length; i++) {
            int num = candidates[i];
            if (num > target) {
                break;
            }
            if(!visited.isEmpty() && visited.get(visited.size()-1) > i) {
                continue;
            }
            visited.add(i);
            list.add(num);
            backtrack(candidates, target - num);
            list.remove(list.size() - 1);
            visited.remove(visited.size() - 1);
        }
    }
}
