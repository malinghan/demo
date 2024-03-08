package data.leetcode.c32;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-07
 */
public class Solution2 {
    public int longestValidParentheses(String s) {
        //保持栈底元素为: 当前已经遍历过的元素中 最后一个没有被匹配的右括号下标
        //对于每个'(', 全部放入栈中
        //每个')',
        //先弹出，如果是'(' 表示匹配了当前右括号
        // 如果栈顶是')', 不弹出
        //每次弹出前，计算括号长度
        //如果栈为空，说明没有匹配的, 开始计算?
        //如果栈不为空, maxLen = i - stack.peek()

        int  n = s.length();
        Deque<Integer> stack = new LinkedList<>();
        //1.为何初始栈顶元素要放-1？因为要保证当有左括号出栈时，有栈顶元素可以配合计算长度（也就是可以相减），选择-1是因为下标是从0开始的
        stack.push(-1);
        int maxLen = 0;
        for(int i = 0; i < n; i++) {
            //2.左括号入栈是因为以左括号结尾的子串有效长度为0，不需要计算直接入栈即可。
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                //4.遇到无法匹配的右括号则入栈，
                //遇到更大下标的右括号则更新，因为一旦有无法匹配的右括号说明其右括号前面遍历过的部分要废掉，
                //因为加上这部分同样形成不了更长的有效括号子串
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    //3.为何要出栈后再减去栈顶元素？
                    //因为栈顶元素实际上就是上一个左括号，在上一个左括号还未出栈（即未匹配到右括号之前），
                    //下标范围(0-上一个左括号)的部分是无法形成有效括号子串的，故应该减去栈顶元素。
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
}