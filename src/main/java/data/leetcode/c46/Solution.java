package data.leetcode.c46;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-02
 */
class Solution {
    List<List<Integer>> res;
    Set<Integer> visited;
    public List<List<Integer>> permute(int[] nums) {
        res = new LinkedList<>();
        visited = new HashSet<>();
        backtrack(nums, new LinkedList<>());
        return res;
    }

    void backtrack(int[] nums,LinkedList<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited.contains(nums[i])) {
                list.add(nums[i]);
                visited.add(nums[i]);
                backtrack(nums, list);
                                list.removeLast();
//                list.remove(list.size() - 1);
                visited.remove(nums[i]);
            }
        }
    }

    public static void main(String[] args) {
        testPermutations();
    }

    // Test method
    public static void testPermutations() {
        int[][] testCases = {
                {1, 1, 2},
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        for (int[] testCase : testCases) {
            System.out.println("Test case: " + Arrays.toString(testCase));
            List<List<Integer>> permutations = new Solution().permute(testCase);
            System.out.println("Permutations:");
            for (List<Integer> permutation : permutations) {
                System.out.println(permutation);
            }
            System.out.println();
        }
    }
}