package data.leetcode.c239;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2023-12-08
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回 滑动窗口中的最大值 。
 * 提示：
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 *
 * 0  1 2 3 4  ///2
 * l = 1
 * k = 2
 * 0 < 2 -1
 */
public class Solution1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //这里一定要用ArrayList,否则会增加复杂度 res.size()
        //有一点细节问题不要忽略，在实现 MonotonicQueue 时，我们使用了 Java 的 LinkedList，
        // 因为链表结构支持在头部和尾部快速增删元素；
        // 而在解法代码中的 res 则使用的 ArrayList 结构，因为后续会按照索引取元素，所以数组结构更合适。
        ArrayList<Integer> res = new ArrayList<>();
        MyQueue myQueue = new MyQueue();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                myQueue.push(nums[i]);
            } else {
                myQueue.push(nums[i]);
                res.add(myQueue.getMax());
                myQueue.pop(nums[i - k + 1]);
            }
        }
        // 需要转成 int[] 数组再返回
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    /**
     * 这个队列叫做单调队列，满足以下性质
     * 1. 队列的长度不超过 k
     * 2. 队列的元素使用LinkedList存储
     * 3. 队列内的元素是单调递减的, 记: linkedList[i] >= linkedList[i+1]
     * 4. 新来的元素会挤爆所有比他小的，已实效单调特性
     */
    class MyQueue {
        LinkedList<Integer> queue = new LinkedList<>();
        //3,2,4,4,2,5  k = 3
        //i=0 4   left_element = 3
        //i=1 4,4  left_element = 2
        //i=2 4,4,2  left_element = 4 queue.pollFirst()
        //i=3 5   left_element = 4
        public void push(int right_element) {
            //这里为什么不是 <= ?
            //4 5 3 5 4
            //这里遇到一个问题？ 5 5 5是保留一个5还是保留 3个 5,
            //为什么不是 queue.getLast() <= right_element
            // 因为如果只保留一个, 当到达左边界时，queue.pollFirst()会被remove, 此时下一个更大的数会被移除
            while (!queue.isEmpty() && queue.getLast() < right_element) {
                queue.pollLast();
            }
            queue.addLast(right_element);
        }

        public int getMax() {
            return queue.getFirst();
        }

        public void pop(int left_element) {
            //这里为什么是 ==  ?
            //因为 queue.getFirst()表示队列的最大值，这里的left_element指的是旧的左边界
            //因为一次只移动一个元素，说明queue.getFirst()除非在左边界，否则不应该被移走

            //如果element < queue.getFirst(), 说明 ei < fi
            //poll的判断条件是: fi < ei，说明poll的时机不成熟

            //如果element > queue.getFirst(),
            // 说明 存在queue中某个下标fi, ei < fi,
            // 因为queue中元素是单调递减的，element > queue.getFirst(),说明 ei > fi
            //矛盾，因为push机制，不会出现这种情况，如果element > queue.getFirst() 就会被顶替成 element == queue.getFirst()
//            if (element == queue.getFirst()) {
            if (left_element == queue.getFirst()) {
                    queue.pollFirst();
                }
        }
    }



    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
    }
}
