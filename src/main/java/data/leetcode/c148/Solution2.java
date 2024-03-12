package data.leetcode.c148;

import data.leetcode.ListNode;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-12
 */
public class Solution2 {
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
        public ListNode sortList(ListNode head) {
            //这个是怎么也想不到的
            return sortList(head, null);
        }

        //分治迭代
        public ListNode sortList(ListNode head, ListNode tail) {
            if (head == null) {
                return head;
            }
            //重叠
            if(head.next == tail) {
                //断开子链表
                head.next = null;
                return head;
            }

            //快慢指针求中点
            ListNode fast = head;
            ListNode slow = head;
            while(fast != tail) {
                slow = slow.next;
                if (fast.next == tail) {
                    fast = fast.next;
                } else {
                    fast = fast.next.next;
                }
            }

            ListNode mid = slow;
            ListNode list1 = sortList(head, mid);
            ListNode list2 = sortList(mid, tail);
            ListNode sorted = merge(list1, list2);
            return sorted;
        }

        //合并2个有序链表
        public ListNode merge(ListNode head1, ListNode head2) {
            ListNode dummy = new ListNode(0);
            ListNode temp = dummy;
            ListNode temp1 = head1;
            ListNode temp2 = head2;
            while (temp1 != null && temp2 != null) {
                if (temp1.val <= temp2.val) {
                    temp.next = temp1;
                    temp1 = temp1.next;
                } else {
                    temp.next = temp2;
                    temp2 = temp2.next;
                }
                temp = temp.next;
            }

            if(temp1 != null) {
                temp.next = temp1;
            }

            if(temp2 != null) {
                temp.next = temp2;
            }

            return dummy.next;
        }
}
