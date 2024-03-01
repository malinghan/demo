package data.leetcode.c103;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import data.leetcode.TreeNode;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-01
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        int level = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while(!deque.isEmpty()) {
            int size = deque.size();
            level++;
            LinkedList<Integer> list = new LinkedList<>();
            while(size > 0) {
                TreeNode node = deque.poll();
                if (level % 2  == 0) {
                    // [20,9]
                    list.offerFirst(node.val);
                } else {
                    list.offerLast(node.val);
                }
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
                size --;
            }
            res.add(list);
        }
        return res;
    }
}