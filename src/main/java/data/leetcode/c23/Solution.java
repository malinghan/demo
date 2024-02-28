package data.leetcode.c23;

import java.util.LinkedHashMap;
import java.util.Map;

import data.leetcode.ListNode;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-28
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
           int n = lists.length;
           ListNode head = null;
           for (int i = 0; i < n; i++) {
               head = mergeTwo(head, lists[i]);
           }
           return head;
    }


    ListNode mergeTwo(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }
        ListNode prev = new ListNode(0);
        ListNode curr = prev;
        ListNode p1 = list1;
        ListNode p2 = list2;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                curr.next = p1;
                p1 = p1.next;
            } else {
                curr.next = p2;
                p2 = p2.next;
            }
            curr = curr.next;
        }
        curr.next = p1 != null ? p1 : p2;
        return prev.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);

        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);

        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);

        System.out.println("原始链表：");
        for (ListNode list : lists) {
            printList(list);
        }

        ListNode mergedList = new Solution().mergeKLists(lists);
        System.out.println("合并后链表：");
        printList(mergedList);

    }

}
