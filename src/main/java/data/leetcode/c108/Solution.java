package data.leetcode.c108;

import data.leetcode.TreeNode;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-01
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 二叉搜索树: BST : 对于任意node满足： node <= node.right   node >= node.left
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0 , nums.length-1);
    }

    TreeNode helper (int[] nums, int l , int r){
         if (l > r) {
             return null;
         }
         int mid = l + (r-l)/2;
         TreeNode midNode = new TreeNode(nums[mid]);
         midNode.left  = helper(nums, l , mid -1);
         midNode.right = helper(nums, mid + 1, r);
         return midNode;
    }
}
