package data.leetcode.c230;

import java.util.Stack;

import data.leetcode.TreeNode;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-01
 */
public class Solution {
    //给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
    public int kthSmallest(TreeNode root, int k) {
        //中序遍历找最小
        int count = 0;
//        int pre = Integer.MIN_VALUE;
        int res =  Integer.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
//            pre = root.val;
            count++;
            if (count == k) {
                res = root.val;
                break;
            }
            root = root.right;
        }
        return res;
    }
}
