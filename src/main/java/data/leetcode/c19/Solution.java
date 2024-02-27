package data.leetcode.c19;

import data.leetcode.ListNode;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-27
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode quick = head;
        if (head.next == null) {
            return null;
        }
        while (count < n) {
            quick = quick.next;
            count++;
        }
        if (quick == null) {
            return head.next;
        }
        ListNode slow = head;
        while (quick.next != null) {
            quick = quick.next;
            slow = slow.next;
        }
        ListNode temp = slow.next.next;
        slow.next = temp;
        return head;
    }
}
