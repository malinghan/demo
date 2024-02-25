package data.leetcode.c76;

import java.util.HashMap;
import java.util.Map;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-25
 */
class Solution3 {
    public String minWindow(String s, String t) {
        //给定2个map： map1, map2
        //map1: 滑动窗口
        //map2: 验证 key: 字符 value: 出现的次数
        //2个指针l, r 需满足: r, l都包含在map2
        Map<Character, Integer> windowMap = new HashMap<>();

        Map<Character, Integer> targetMap = new HashMap<>();
        for(int i = 0; i < t.length(); i++) {
            targetMap.putIfAbsent(t.charAt(i), 0);
            targetMap.put(t.charAt(i), targetMap.get(t.charAt(i))+1);
        }
        int l = 0;
        int r = 1;
        //初始化map1,把s的第一个字符加进去
        windowMap.putIfAbsent(s.charAt(0), 0);
        windowMap.put(s.charAt(0), windowMap.get(s.charAt(0))+1);
        //结果假定
        int minLen = Integer.MAX_VALUE;
        //左闭右开
        int minL = -1;
        int minR = 0;
        //开始滑动
        while(r <= s.length()) {
            //判断:
            while(l < r && valid(windowMap, targetMap)) {
                //  while(valid(map1, map2) && l < r) {
                if (r - l < minLen) {
                    minLen = r-l;
                    minL = l;
                    minR =  r;
                }
                //移动l
                windowMap.putIfAbsent(s.charAt(l), 0);
                windowMap.put(s.charAt(l), windowMap.get(s.charAt(l))-1);
                l++;
            }
            //移动r
            if (r < s.length()) {
                windowMap.putIfAbsent(s.charAt(r), 0);
                windowMap.put(s.charAt(r), windowMap.get(s.charAt(r)) + 1);
            }
            r++;
        }
        //可能存在空串，需考虑
        return minL == -1 ? "" : s.substring(minL,minR);
    }

    //map1包含所有map2，且count不少,视为有效
    boolean valid(Map<Character, Integer> windowMap, Map<Character, Integer> targetMap) {
        for (Character value: targetMap.keySet()) {
            if (!windowMap.containsKey(value) || windowMap.get(value) < targetMap.get(value)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().minWindow("ADOBECODEBANC", "ABC"));
        //        System.out.println(new Solution1().minWindow("A", "B"));
    }
}
