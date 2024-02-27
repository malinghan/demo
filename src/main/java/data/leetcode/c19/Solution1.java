package data.leetcode.c19;

import data.leetcode.ListNode;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-27
 */
public class Solution1 {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode first = dummy;
            ListNode second = dummy;

            // Move second pointer to the nth node from the beginning
            for (int i = 0; i <= n; i++) {
                if (second == null) return null; // Handle cases where n is larger than the length of the list
                second = second.next;
            }

            // Move both pointers until second reaches the end
            while (second != null) {
                first = first.next;
                second = second.next;
            }

            // Now first is pointing to the node just before the one we want to delete
            first.next = first.next.next;

            return dummy.next; // Return the head of the modified list
        }

        // Helper method to print the linked list
        public static void printList(ListNode head) {
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
            printList(head);

            int n = 2; // Nth node from the end to delete
            head = new Solution1().removeNthFromEnd(head, n);

            System.out.println("List after removing " + n + "th node from end:");
            printList(head);
        }
}
