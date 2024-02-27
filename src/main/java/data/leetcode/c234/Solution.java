package data.leetcode.c234;

import data.leetcode.ListNode;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-27
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode quick = head;
        ListNode slow = head;
        // 1 -> 2 -> 3
        // 1 -> 2 -> 3 -> 4
        while(quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
            if (quick != null && quick.next == null) {
                slow = slow.next;
            }
        }
        //翻转
        slow = reverse(slow);
        quick = head;
        while(slow != null) {
            if (slow.val != quick.val) {
               return false;
            }
            slow = slow.next;
            quick = quick.next;
        }
        return true;
    }

    ListNode reverse(ListNode head) {
        ListNode newHead = null;
        ListNode node = head;
        while(node != null) {
            ListNode next = node.next;
            node.next = newHead;
            newHead = node;
            node = next;
        }
        return newHead;
    }

}
