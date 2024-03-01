package data.leetcode.c98;

import data.leetcode.TreeNode;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-01
 */
public class Solution {
    /**
     * 是否是有效的二叉搜索树
     * @param root
     * @return
     *      root
     * lower    upper
     */
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean helper(TreeNode root, long lower, long upper) {
        if (root == null) {
            return true;
        }
        if (lower >= root.val) {
            return false;
        }
        if (upper <= root.val) {
            return false;
        }
        return helper(root.left, lower, root.val) && helper(root.right, root.val, upper);
    }
}
