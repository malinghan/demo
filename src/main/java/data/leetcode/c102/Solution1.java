package data.leetcode.c102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import data.leetcode.TreeNode;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-01
 */
public class Solution1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
          List<List<Integer>> res = new ArrayList<>();
           if (root == null) {
               return res;
           }
           Queue<TreeNode> queue = new LinkedList<>();
           queue.offer(root);
           while(!queue.isEmpty()) {
               int size = queue.size();
               List<Integer> list = new ArrayList<>();
               while (size > 0) {
                   TreeNode node = queue.poll();
                   if (node != null) {
                       list.add(node.val);
                       queue.offer(node.left);
                       queue.offer(node.right);
                   }
                   size --;
               }
               res.add(list);
           }
           return res;
    }
}
