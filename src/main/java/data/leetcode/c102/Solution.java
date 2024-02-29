package data.leetcode.c102;

import java.util.ArrayList;
import java.util.List;

import data.leetcode.TreeNode;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-01
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(1, root, res);
        return res;
    }

    void dfs(int index, TreeNode root, List<List<Integer>> res) {
        //[] -> [[][]]
        if (res.size() < index) {
            res.add(new ArrayList<Integer>());
        }
        //[ [] ]
        res.get(index - 1).add(root.val);
        //[[1]]
        if (root.left != null) {
            dfs(index + 1, root.left, res);
        }
        if(root.right != null) {
            dfs(index + 1, root.right, res);
        }
    }
}
