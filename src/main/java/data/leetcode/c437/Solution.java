package data.leetcode.c437;

import data.leetcode.TreeNode;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-01
 */
public class Solution {
        public int pathSum(TreeNode root, int sum) {
            if (root == null) return 0;
            return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        }

        private int pathSumFrom(TreeNode node, long sum) {
            if (node == null) return 0;
            int res = 0;
            if (node.val == sum) {
                res = 1;
            }
            return res
                    + pathSumFrom(node.left, sum - node.val)
                    + pathSumFrom(node.right, sum - node.val);
        }
    }

