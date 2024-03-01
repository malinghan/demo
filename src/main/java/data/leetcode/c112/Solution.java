package data.leetcode.c112;

import data.leetcode.TreeNode;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-01
 * 二叉树的回溯
 * 每走一步计算路径path，如果超过，回头
 */
public class Solution {
    boolean flag = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, 0);
        return flag;
    }

    void dfs(TreeNode root, int targetSum, int path) {
        if (root == null) {
            return;
        }
        int newPath =  path + root.val;
        if (root.left == null && root.right == null) {
            if (newPath == targetSum) {
                flag = true;
                return;
            }
        }
        dfs(root.left, targetSum, newPath);
        dfs(root.right, targetSum, newPath);
    }
}
