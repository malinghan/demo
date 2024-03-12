package data.leetcode.c148;

import data.leetcode.ListNode;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-28
 * 归并思想
 */
public class Solution1 {

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head; // 链表为空或只有一个节点时，无需排序，直接返回
        }

        ListNode middle = getMiddle(head); // 获取链表的中间节点
        ListNode nextOfMiddle = middle.next;
        middle.next = null; // 断开链表，分成两个独立的子链表

        ListNode left = sortList(head); // 对左半部分链表进行排序
        ListNode right = sortList(nextOfMiddle); // 对右半部分链表进行排序

        return merge(left, right); // 合并排序后的左右两个子链表
    }

    private static ListNode getMiddle(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static ListNode merge(ListNode left, ListNode right) {
        if (left == null) return right;
        if (right == null) return left;

        ListNode result = null;
        if (left.val <= right.val) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }

        return result;
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

        ListNode sortedList = sortList(head);
        System.out.println("排序后链表：");
        printList(sortedList);
    }
}

