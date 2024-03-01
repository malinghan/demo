package data.leetcode.c105;

import java.util.Stack;

import data.leetcode.TreeNode;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-01
 * 原理：
 * 前序遍历，根节点在中序遍历数组中所在的位置，标记了有多少左子树
 * 中序遍历
 * 非递归方法构造二叉树的关键是利用栈来模拟递归调用过程。在这个问题中，我们需要使用前序遍历序列和中序遍历序列来构建二叉树。具体步骤如下：
 * 1. 从前序遍历序列中取出根节点，并创建该节点。
 * 2. 将根节点入栈。
 * 3. 从中序遍历序列中找到根节点的位置，并将该位置左边的部分称为左子树，右边的部分称为右子树。
 * 4. 对于左子树，重复步骤1-3，直到左子树为空。
 * 5. 对于右子树，重复步骤1-3，直到栈为空或者右子树构建完成。
 * 实现过程：
 * 1. 定义一个 stack，将root = preorder[0] 压入 stack
 * 2. 定义一个 inorderIndex，标记 其在inorder中的位置
 * 3. inorder中for寻找查找
 *    3.1   弹出stack， 获取 current;
 *    3.2 如果 current.val == inorder[inorderIndex]：说明找到了中间节点的位置
 *          循环弹出栈且inorderIndex++；直到stack为空或current.val != inorder[inorderIndex]
 *          设置current.right = new TreeNode(preorder[i]);
 *          压入stack.push(current.right);
 *   3.3   如果 current.val != inorder[inorderIndex]： 说明inorder[inorderIndex] 是current左子树的一个节点
 *          current.left = new TreeNode(preorder[i]);
 *          stack.push(current.left);
 *
 */
public class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0)
                return null;

            TreeNode root = new TreeNode(preorder[0]);
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            int inorderIndex = 0;

            for (int i = 1; i < preorder.length; i++) {
                TreeNode current = stack.peek();
                if (current.val != inorder[inorderIndex]) {
                    current.left = new TreeNode(preorder[i]);
                    stack.push(current.left);
                } else {
                    while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                        current = stack.pop();
                        inorderIndex++;
                    }
                    current.right = new TreeNode(preorder[i]);
                    stack.push(current.right);
                }
            }
            return root;
        }

        // 辅助函数，用于打印树的中序遍历结果
        private void inorderTraversal(TreeNode root) {
            if (root != null) {
                inorderTraversal(root.left);
                System.out.print(root.val + " ");
                inorderTraversal(root.right);
            }
        }

        public static void main(String[] args) {
            Solution solution = new Solution();

            int[] preorder = {3, 9, 20, 15, 7};
            int[] inorder = {9, 3, 15, 20, 7};

            TreeNode root = solution.buildTree(preorder, inorder);

            // 打印中序遍历结果，验证构造是否正确
            solution.inorderTraversal(root); // 应该输出：9 3 15 20 7
        }
}
