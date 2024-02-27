package data.leetcode.c2;

import data.leetcode.ListNode;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-27
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0;
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dump = new ListNode(0);
        ListNode node = dump;
        //..
        while(p1 != null || p2 != null) {
            int p1v = p1 != null ? p1.val : 0;
            int p2v =  p2 != null ? p2.val : 0;
            int value = p1v +p2v + flag;
            if (value >= 10) {
                value = value - 10;
                flag = 1;
            } else {
                flag = 0;
            }
            node.next = new ListNode(value);
            node = node.next;
            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }
        }
        if (flag == 1) {
            node.next =  new ListNode(1);
        }
        return dump.next;
    }
}
