package data.leetcode.c104;

import data.leetcode.TreeNode;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-29
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return  Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}
