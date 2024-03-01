package data.leetcode.c98;

import data.leetcode.TreeNode;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-01
 */
public class Solution1 {
    /**
     * 是否是有效的二叉搜索树
     * @param root
     * @return
     */
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        // 验证当前节点，如果前一个节点存在且当前节点的值不大于前一个节点的值，则不是BST
        if (pre >= root.val) {
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }

    public static void main(String[] args) {
        Solution1 validator = new Solution1();

        // 构建一个二叉树
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        // 验证是否为二叉搜索树
        System.out.println(validator.isValidBST(root)); // 应该输出 true
    }
}
