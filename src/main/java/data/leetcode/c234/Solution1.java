package data.leetcode.c234;

import data.leetcode.ListNode;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-27
 */
public class Solution1 {
    public boolean isPalindrome(ListNode head) {
        //翻转
        ListNode firstHalfEnd = findHalf(head);
        ListNode secondHalfStart = reverse(firstHalfEnd.next);
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while( result && p2 != null) {
            if (p2.val != p1.val) {
                result = false;
            }
            p2 = p2.next;
            p1 = p1.next;
        }
        // 还原链表并返回结果
        firstHalfEnd.next = reverse(secondHalfStart);
        return result;
    }

    ListNode findHalf(ListNode head) {
        ListNode quick = head;
        ListNode slow = head;
        // 1 -> 2 -> 3  -> 4 -> 5
        // 1 -> 2 -> 3 -> 4
        while(quick.next != null && quick.next.next != null) {
            quick = quick.next.next;
            slow = slow.next;
        }
        return slow;
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
