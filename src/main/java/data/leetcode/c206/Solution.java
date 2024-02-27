package data.leetcode.c206;

import data.leetcode.ListNode;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-27
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        // 1 -> 2 -> 3 -> null
        // null <- 1 <- 2 <- 3
        ListNode newHead = null;
        ListNode node = head;
        while(node != null) {
            ListNode next = node.next;
            node.next = newHead;
            newHead = node;
            node = next;
        }
        return  newHead;
    }
}
