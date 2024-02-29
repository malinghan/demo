package data.leetcode.c543;

import data.leetcode.TreeNode;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-29
 * 求二叉树的最长长度
 * 深度 -> 数量 -> 长度
 * count = Max(depthLeft + depthRight + 1, count)
 * len = count -1;
 */
public class Solution {
    //找到p q 使得 p与q距离最远
    //case1: p q 有一个是root，找最大深度
    //case2: p q在 root两边，找最大深度
    int nodeCount = 0;
    public int diameterOfBinaryTree(TreeNode root) {
         depth(root);
         return  nodeCount - 1;
    }

    int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        //每经过一个点，就开始计算最大节点数
        nodeCount  = Math.max(nodeCount, left + right + 1);
        return Math.max(left, right) + 1;
    }
}
