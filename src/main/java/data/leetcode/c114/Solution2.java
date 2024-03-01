package data.leetcode.c114;

import data.leetcode.TreeNode;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-01
 */
public class Solution2 {
    public void flatten(TreeNode root) {
        if (root == null) return;

        while (root != null) {
            // 如果左子树为空，直接处理右子树
            if (root.left == null) {
                root = root.right;
            } else {
                TreeNode curr = root.left;
                // 找到左子树的最右节点
                while (curr.right != null) {
                    curr = curr.right;
                }
                // 将根节点的右子树接到左子树的最右节点上
                curr.right = root.right;
                // 将左子树接到根节点的右子树上
                root.right = root.left;
                root.left = null;
                // 处理下一个节点
                root = root.right;
            }
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        // 构建二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        // 展开为链表
        solution.flatten(root);

        // 输出链表
        TreeNode node = root;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.right;
        }
        // 输出应为：1 2 3 4 5 6
    }
}

