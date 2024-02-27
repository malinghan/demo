package data.leetcode.c24;

import data.leetcode.ListNode;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-27
 */
public class Solution1 {
    public ListNode swapPairs(ListNode head) {
        // Create a dummy node and make it the head of the list
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Initialize two pointers, prev and curr, to track the nodes
        ListNode prev = dummy;
        ListNode curr = head;
        // dummy ->  1        -> 2   -> 3 -> 4 -> 5 -> 6
        // prev  -> curr
        //          first    second

        //     3 <-  1    <-   2
        //    curr   prev
        // Traverse the list and swap pairs of nodes
        while (curr != null && curr.next != null) {
            // Nodes to be swapped
            ListNode first = curr;
            ListNode second = curr.next;

            // Swapping
            prev.next = second;
            first.next = second.next;
            second.next = first;

            // Move pointers forward for the next pair
            prev = first;
            curr = first.next;
        }

        // Return the head of the modified list
        return dummy.next;
    }

    // Helper method to print the linked list
    public void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        new Solution1().printList(head);

        // Swap pairs of nodes
        head = new Solution1().swapPairs(head);

        System.out.println("List after swapping pairs:");
        new Solution1().printList(head);
    }
}

