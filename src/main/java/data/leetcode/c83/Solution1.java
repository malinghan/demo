package data.leetcode.c83;

import data.leetcode.ListNode;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-24
 */
public class Solution1 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode slow = head;
        while(slow !=null && slow.next != null) {
            ListNode fast = slow.next;
            if (slow.val == fast.val) {
                slow.next = fast.next;
            } else {
                slow = slow.next;
            }
        }
        return head;
    }
}
