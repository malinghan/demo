package data.leetcode.c114;

import java.util.ArrayList;
import java.util.List;

import data.leetcode.TreeNode;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-01
 * O(1)空间复杂度原地实现
 * 方法: 前序遍历
 * 原理: 前序遍历二叉树，将结果封装在List中,再按顺序拼接在一起
 */
public class Solution {
    List<TreeNode> list;
    public void flatten(TreeNode root) {
        list = new ArrayList<>();
        inorder(root);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i-1);
            TreeNode curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root);
        inorder(root.left);
        inorder(root.right);
    }
}
