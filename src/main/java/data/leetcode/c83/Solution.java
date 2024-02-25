package data.leetcode.c83;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2023-12-01
 */

import data.leetcode.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution {
    //给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
    public ListNode deleteDuplicates(ListNode head) {
        ListNode prev = head;
        while (prev != null && prev.next != null) {
            ListNode curr = prev.next;
            if (prev.val == curr.val) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }
}
