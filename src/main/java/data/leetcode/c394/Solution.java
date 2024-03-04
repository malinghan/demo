package data.leetcode.c394;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-04
 */
class Solution {
    public String decodeString(String s) {
        //会存在括号嵌套问题，所以必须使用栈来解决
        // 3[[a 2[bc]]]
        //abcbcabcbcabcbc
        //如何找到最里面的[
        //数字: 标识了一个 重复串的起点
        LinkedList<String> stack = new LinkedList<>();
        int i = 0;
        while(i < s.length()) {
            char curr = s.charAt(i);
            if (Character.isDigit(curr)) {
                //获取一个数字入栈
                String digits = "";
                StringBuilder res = new StringBuilder();
                while(Character.isDigit(s.charAt(i))) {
                    res.append(s.charAt(i));
                    i++;
                }
                digits = res.toString();
                stack.push(digits);
            } else if (Character.isLetter(curr) || curr ==  '[') {
                stack.push(String.valueOf(s.charAt(i)));
                i++;
            } else {
                i++;
                //装填数字
                LinkedList<String> list = new LinkedList<String>();
                while(! "[".equals(stack.peek())) {
                    list.addLast(stack.pop());
                }
                Collections.reverse(list);
                //弹出 ']'
                stack.pop();
                //此时stack顶部为list对应字符串应该出现的次数
                int number = Integer.parseInt(stack.pop());
                //表示通过重复解码的字符串
                StringBuffer t  = new StringBuffer();
                StringBuffer ret = new StringBuffer();
                for(String str: list) {
                    ret.append(str);
                }
                //需要重复的字符串，对应list
                String o = ret.toString();
                while(number > 0) {
                    t.append(o);
                    number--;
                }
                //将构造好的字符串入栈，便于下一次继续
                stack.push(t.toString());
            }
        }
        //此时，stack中全是解码之后的字符串，出栈
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()) {
            // res.append(stack.pop());
            res.append(stack.removeLast());
        }
        return res.toString();
    }
}