package data.leetcode.c21;

import data.leetcode.ListNode;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-27
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dumb = new ListNode(0);
        ListNode node = dumb;
        ListNode n1 = list1;
        ListNode n2 = list2;
        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                node.next = n1;
                n1 = n1.next;
            } else {
                node.next = n2;
                n2 = n2.next;
            }
            node = node.next;
        }
        if (n1 == null) {
            node.next = n2;
        }
        if (n2 == null) {
            node.next = n1;
        }
        return dumb.next;
    }
}
