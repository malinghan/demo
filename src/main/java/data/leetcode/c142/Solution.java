package data.leetcode.c142;

import data.leetcode.ListNode;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-27
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode quick = head, slow = head;
        while (true) {
            if (quick == null || quick.next == null) {
                return null;
            }
            quick = quick.next.next;
            slow = slow.next;
            if (quick == slow) {
                break;
            }
        }
        quick = head;
        while (quick != slow) {
            quick = quick.next;
            slow = slow.next;
        }
        return slow;
    }
}
