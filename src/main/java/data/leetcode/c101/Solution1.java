package data.leetcode.c101;

import java.util.LinkedList;
import java.util.Queue;

import data.leetcode.TreeNode;
import sun.awt.image.ImageWatched.Link;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-29
 */
public class Solution1 {
    //每次加2个, 每次移除2个， 2 2 一组 形成对称比较
    //null也算一个节点，除非left和right全为null
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            //如果两个节点都为空就继续循环，两者有一个为空就返回false
            if (left == null && right == null) {
//                return true;
                continue;
            }
            if (left == null) {
                return false;
            }
            if( right == null) {
                return false;
            }
            if (left.val != right.val) {
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }

}
