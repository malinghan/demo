package data.leetcode.c141;

import data.leetcode.ListNode;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-27
 */
public class Solution {
    //|-a--|----b------|
    // 3 -> 2 -> 0 -> -4
    //      |——————————|
    //快慢指针
    //
    //终止条件：
    //  如果不构成,快的一定到时候为null
    //  如果构成，快的被慢的追上了, 就会有 quick = slow
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode quick = head.next;
        ListNode slow = head;
        while (quick != null && quick.next != null) {
            if (quick == slow) {
                return true;
            }
            quick = quick.next.next;
            slow = slow.next;
        }
        return false;
    }
}
