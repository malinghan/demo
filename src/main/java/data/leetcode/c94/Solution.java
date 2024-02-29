package data.leetcode.c94;

import java.util.ArrayList;
import java.util.List;

import data.leetcode.TreeNode;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-29
 */
public class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }
        if (root.left != null) {
            inorderTraversal(root.left);
        }
        res.add(root.val);
        if (root.right != null) {
            inorderTraversal(root.right);
        }
        if (root.left == null && root.right == null) {
            return res;
        }
        return res;
    }
}
