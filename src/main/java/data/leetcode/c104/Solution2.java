package data.leetcode.c104;

import java.util.Stack;

import data.leetcode.TreeNode;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-29
 */
public class Solution2 {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int maxDepth = 0;

        while (!stack.isEmpty()) {
            int size = stack.size();
            maxDepth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = stack.pop();
                if (node.left != null)
                    stack.push(node.left);
                if (node.right != null)
                    stack.push(node.right);
            }
        }

        return maxDepth;
    }

    public static void main(String[] args) {
        // 创建二叉树
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // 计算二叉树的最大深度
        Solution2 treeDepth = new Solution2();
        int depth = treeDepth.maxDepth(root);
        System.out.println("二叉树的最大深度为: " + depth);
    }
}
