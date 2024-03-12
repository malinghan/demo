package data.leetcode.c148;

import data.leetcode.ListNode;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-27
 * 归并思想-非递归
 * 先拆分，再合并，拆分的粒度
 */
public class Solution {

    public ListNode sortList(ListNode head) {
      //1. ListNode split(left, size)
      //2. ListNode merge(left, right, prev)
        ListNode dummy = new ListNode(0, head);
        int len = getLength(head);
        for(int size = 1; size < len; size = 2 * size) {
            ListNode prev = dummy;
            ListNode current = dummy.next;
            while (current != null) {
                ListNode left = current;
                ListNode right = split(left, size);
                current = split(right, size);
                prev = merge(left, right, prev);
            }
        }
      return dummy.next;
    }

    ListNode split(ListNode left, int size) {
        if (left == null) {
            return null;
        }
        int i = 1;
        while(left.next != null && i < size) {
            left = left.next;
            i++;
        }
        ListNode right = left.next;
        left.next = null;
        return right;
    }

    ListNode merge(ListNode left, ListNode right, ListNode prev) {
        //将2个有序链表合并
        ListNode curr = prev;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            curr = curr.next;
        }

        curr.next = left == null ? right : left;

        while (curr.next != null) {
            curr = curr.next;
        }
        return curr;
    }

    int getLength(ListNode head) {
        ListNode curr = head;
        int count = 0;
        while(curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        System.out.println("原始链表：");
        printList(head);

        ListNode sortedList = new Solution().sortList(head);
        System.out.println("排序后链表：");
        printList(sortedList);
    }


}
