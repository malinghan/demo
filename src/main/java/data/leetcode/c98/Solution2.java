package data.leetcode.c98;

import java.util.Stack;

import data.leetcode.TreeNode;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-01
 * 中序非递归遍历期间，验证其单调性
 * 1. 定义一个栈 stack
 * 2. left遍历，并记录 pre; while(left != null) {stack.push(left)}
 * 3. 出栈时，root = stack.pop(), 判断 pre和 root的大小
 * 4. 若为false终止，若为true，pre = root
 * 4. 向right遍历，root = root.right
 * 6. 终止条件： stack为空，或 没有右节点
 *
 * 这段代码的原理如下：
 *
 * 初始化: 创建一个空栈stack用于存储将要访问的节点，inorder变量用于记录上一个访问的节点的值。
 * 这里将inorder初始化为-Double.MAX_VALUE，以允许树中的第一个节点值为任何有效的整数值。
 *
 * 中序遍历:
 * 首先，我们尝试访问尽可能左侧的节点，并将途径的所有节点推入栈中。
 * 当到达最左侧节点后，从栈中弹出一个节点，此时该节点没有左孩子或者左孩子已经被访问过。
 * 检查当前节点的值是否大于inorder变量中的值。如果不是，则说明找到了一个不符合二叉搜索树性质的节点，直接返回false。
 * 更新inorder为当前节点的值，并将root设置为当前节点的右孩子，然后重复上述过程直到栈为空且没有右孩子为止。
 * 这种方法的优势在于它不需要递归调用，从而减少了调用栈空间的消耗，使得空间复杂度仅为O(h)，其中h是树的高度，适用于深度较大的二叉树。
 */
public class Solution2 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
         Stack<TreeNode> stack = new Stack<>();
         long pre = Long.MIN_VALUE;
         while (!stack.isEmpty() || root != null) {
             while (root != null) {
                 stack.push(root);
                 root = root.left;
             }
             root = stack.pop();
             if (pre >= root.val) {
                 return false;
             }
             pre = root.val;
             root = root.right;
         }
         return true;
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
