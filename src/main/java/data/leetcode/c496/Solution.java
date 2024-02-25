package data.leetcode.c496;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2023-12-08
 * 实现一个单调栈的模板
 * for(int  i = nums2.length-1; i >= 0;i--) {
 *    //矮个子走开
*      while(!s.isEmpty() && nums2[i] > s.peek()) {
*          s.pop();
*      }
 *      //在此取值
*      int value = s.isEmpty() ? -1:s.peek();
 *      map.put(nums2[i], value);
*      s.push(nums2[i]);
 *   }
 */
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> s = new Stack<>();
        // 3 => 4, 2
        //核心思路: 入栈时按栈头到栈尾单调递减存放
        //如果遇到nums[i] < peek() 就往里面放
        //如果遇到nums[i] > peek() 就弹出peek(), 表示被nums[i]挡住了
        //1.单调栈需要操作指针吗？如何实现循环遍历？
        //使用for循环，从右往左遍历
        //2. 单调栈是单调递增还是递减？
        //3. 在哪个阶段输出结果？
        //第一步: push
        //第二步: while(pop)
        for(int  i = nums2.length-1; i >= 0;i--) {
            //把比peeknums2[i]
            while(!s.isEmpty() && nums2[i] >= s.peek()) {
                s.pop();
            }
            int value = s.isEmpty() ? -1:s.peek();
            map.put(nums2[i], value);
            s.push(nums2[i]);
        }
        int[] ans = new int[nums1.length];
        for(int  j = 0; j < nums1.length;j++) {
            ans[j] = map.get(nums1[j]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2})));
    }
}
