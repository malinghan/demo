package data.leetcode.c104;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import data.leetcode.TreeNode;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-29
 */
public class Solution3 {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int maxDepth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            maxDepth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
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
        Solution3 treeDepth = new Solution3();
        int depth = treeDepth.maxDepth(root);
        System.out.println("二叉树的最大深度为: " + depth);
    }
}
