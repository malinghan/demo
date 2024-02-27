package data.leetcode.c24;

import data.leetcode.ListNode;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-27
 */
class Solution {
    // 1 -> 2 -> 3 -> 4
    // 1 <- 2 <- dumb     3 -> 4
    //         node curr   next
    //temp -> node next  later
    //      // 1 -> 2  -> 3 -> 4
    //                   |<- temp
    //      // 3 -> 1 <- 2 <- dump
    public ListNode swapPairs(ListNode head) {
        ListNode node = head;
        ListNode dump = new ListNode(0);
        dump.next = node;
        ListNode temp = dump;
        while (node.next != null) {
            ListNode next = node.next;
            ListNode later = next.next;
            temp.next = later;
            next.next = later.next;
            later.next = next;
            temp = next;
        }
        return dump;
    }
}
