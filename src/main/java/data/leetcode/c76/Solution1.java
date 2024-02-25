package data.leetcode.c76;

import java.util.HashMap;
import java.util.Map;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2023-12-06
 * 提示：
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s 和 t 由英文字母组成
 *
 * 难点: 可变
 */
public class Solution1 {
    public String minWindow(String s, String t) {
        //最小子串: 第0个和第len-1个是在t中的character
        Map<Character, Integer> count = new HashMap<>();
        Map<Character, Integer> count1 = new HashMap<>();
        if (s.length() < t.length()) {
            return "";
        }
        for (int i = 0; i < t.length(); i++) {
            count.putIfAbsent(t.charAt(i),0);
            count.put(t.charAt(i), count.get(t.charAt(i))+1);
        }
        int l = 0 , r = 0;
        //aaaaaaabbbbabcccccc  abc
        //aaaaaaabbbbabc abc
        //abbbbabc abc
        //bbbbabc abc
        int minLen  = Integer.MAX_VALUE;
        int minL = -1;
        int minR = 0;
        while (r <= s.length()) {
            while(check(count, count1) && l < r) {
                if (r - l < minLen) {
                    minLen = r-l;
                    minL = l;
                    minR =  r;
                }
                count1.putIfAbsent(s.charAt(l),0);
                count1.put(s.charAt(l), count1.get(s.charAt(l))-1);
                l++;
            }
            if (r < s.length()) {
                count1.putIfAbsent(s.charAt(r), 0);
                count1.put(s.charAt(r), count1.get(s.charAt(r)) + 1);
            }
            r++;
        }
        return minL == -1 ? "" : s.substring(minL,minR);
    }

    boolean check(Map<Character, Integer> count,  Map<Character, Integer> count1) {
        for (Character value : count.keySet()) {
            if (!count1.containsKey(value) || count1.get(value) < count.get(value)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
//        System.out.println(new Solution1().minWindow("A", "B"));
    }
}
