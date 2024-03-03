package data.leetcode.c47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-03
 */
public class Solution {
    List<List<Integer>> res;
    Set<Integer> used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        used = new HashSet<>();
        res = new ArrayList<>();
        backtrack(nums, new ArrayList<>());
        return res;
    }

    void backtrack(int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
        }
        // res.add(new ArrayList<>(list));
        for(int i = 0; i < nums.length; i++) {
            if (used.contains(i)) {
                continue;
            }
            // if (i > 0 && nums[i] == nums[i-1]) {
            //     continue;
            // }
            //i > 0 && nums[i] == nums[i-1] && used.contains(i-1) 也行
            if (i > 0 && nums[i] == nums[i-1] && !used.contains(i-1)) {
                continue;
            }
            list.add(nums[i]);
            used.add(i);
            backtrack(nums, list);
            list.remove(list.size() -1);
            used.remove(i);
        }
    }

    public static void main(String[] args) {
        testPermutations();
    }

    public static void testPermutations() {
        int[][] testCases = {
                {1, 1, 2},
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        for (int[] testCase : testCases) {
            System.out.println("Test case: " + Arrays.toString(testCase));
            List<List<Integer>> permutations = new Solution().permuteUnique(testCase);
            System.out.println("Permutations:");
            for (List<Integer> permutation : permutations) {
                System.out.println(permutation);
            }
            System.out.println();
        }
    }
}
