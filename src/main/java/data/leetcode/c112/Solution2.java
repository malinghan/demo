package data.leetcode.c112;

import data.leetcode.TreeNode;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-01
 * 二叉树的回溯 优化
 * 每走一步计算路径path，如果超过，回头
 */
public class Solution2 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        int newSum = targetSum - root.val;
        if (root.left == null && root.right == null) {
            return newSum == 0;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
