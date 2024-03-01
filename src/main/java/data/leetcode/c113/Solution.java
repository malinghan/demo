package data.leetcode.c113;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import data.leetcode.TreeNode;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-01
 */
public class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
          res = new ArrayList<>();
          dfs(root, targetSum, new LinkedList<>());
          return res;
    }

    void dfs(TreeNode root, int targetSum, LinkedList<Integer> arr) {
        if (root == null) {
            return;
        }
        arr.add(root.val);
        if (root.left == null && root.right == null && targetSum - root.val == 0) {
            res.add(new LinkedList<>(arr));
        }
        dfs(root.left, targetSum - root.val, arr);
        dfs(root.right, targetSum - root.val, arr);
        arr.removeLast();
    }
}
