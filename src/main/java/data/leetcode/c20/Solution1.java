package data.leetcode.c20;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-04
 */
class Solution1 {
    private static Map<Character, Character> map = new HashMap<Character, Character>() {
        {
            put(')', '(');
            put('}', '{');
            put(']', '[');
        }
    };

    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        // ([])
        for(int i = 0 ; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || map.get(c) != stack.peek()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
