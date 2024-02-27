package data.leetcode.c160;

import data.leetcode.ListNode;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-27
 */
public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            /**
             *     a1 -> a2
             *                -> c1 -> c2 -> c3
             * b1-> b2-> b3
             *
             *  node1
             *       a         c
             *     |------|------|
             *  |----b----|
             *  a < b
             *  要让节点在a处跑到a, 在b处跑到b
             *  currA跑到尽头需要: a + c
             *  currB跑到尽头需要: b + c
             *  currA跑到终点时，currB跑了 a+c, 还剩下 b+c - (a+c) = b-a
             *  |------|--|------|
             *  |--------|-(b-a)-|
             *  此时把currA放到b的原点，currB继续跑，
             *  currB跑到终点时，currA在b跑道的 b-a处，还剩下 b+c - (b-a) = c+a
             *  此时把currB放到a的原点,一起跑。这样 currA和currB距离终点的距离是一样的，那么如果相交的话一定可以相遇
             *
             *  如果A和B没有相交点，则会出现 currA == currB = null
             */
            ListNode currA = headA;
            ListNode currB = headB;
            while (currA != currB) {
                //相交的判断条件是什么？
                if (currA != null) {
                    currA = currA.next;
                } else {
                    currA = headB;
                }
                if (currB != null) {
                    currB = currB.next;
                } else {
                    currB = headA;
                }
            }
            return currA;
        }

    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = new ListNode(8);
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);
//          [4,1,8,4,5]
        //[5,6,1,8,4,5]
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = headA.next;
        ListNode result = new Solution().getIntersectionNode(headA, headB);
        System.out.println(result.val);
    }
}
