package data.leetcode.c114;

import java.util.ArrayList;
import java.util.List;

import data.leetcode.TreeNode;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-01
 * O(1)空间复杂度原地实现
 * 方法: 前序遍历 + 展开同步进行
 * 原理: 前序遍历二叉树，将结果封装在List中,再按顺序拼接在一起
 */
public class Solution1 {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        flatten(left);
        flatten(right);
        if (prev != null) {
            prev.left = null;
            prev.right = root;
        }
        prev = root;
    }
}
