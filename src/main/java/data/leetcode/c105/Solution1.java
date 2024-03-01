package data.leetcode.c105;

import java.util.HashMap;
import java.util.Map;

import data.leetcode.TreeNode;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-01
 */
public class Solution1 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen  = inorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inLen; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, map, 0, preLen -1, 0, inLen -1);
    }

    // preStart | (inIndex - inStart)  | preEnd
    //  inStart        (inIndex -1)    inIndex (inIndex + 1)  inEnd
    private TreeNode buildTree(int[] preorder, Map<Integer, Integer> map,
            int preStart, int preEnd, int inStart, int inEnd) {
            if (preStart > preEnd || inStart > inEnd) {
                return null;
            }
            int rootval = preorder[preStart];
            TreeNode root = new TreeNode(rootval);
            int inIndex = map.get(rootval);
            root.left = buildTree(preorder, map,preStart +1 , inIndex - inStart + preStart,
                    inStart, inIndex -1);
            root.right = buildTree(preorder, map, inIndex - inStart + preStart + 1, preEnd,
                    inIndex +1,  inEnd);
            return root;
    }
}
