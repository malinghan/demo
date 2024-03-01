package data.leetcode.c236;

import data.leetcode.TreeNode;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-01
 * 1. 4个情况
 */
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
          if(root == null || root == p || root == q){
            return root;
        }
         TreeNode left = lowestCommonAncestor(root.left,  p,  q);
         TreeNode right = lowestCommonAncestor(root.right,  p,  q);
        if (left == null && right == null) {
            return null;
        }
         if (left == null) {
             return right;
         }
         if (right == null) {
             return left;
         }
         return root; //if(left != null and right != null)
    }
}
