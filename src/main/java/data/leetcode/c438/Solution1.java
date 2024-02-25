package data.leetcode.c438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2023-12-06
 * 优化思路: 构建count1时，只需要滑动即可，即左去右加
 */
public class Solution1 {
        //438. 找到字符串中所有字母异位词
        //给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
        //异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
        //提示:
        //1 <= s.length, p.length <= 3 * 104
        //s 和 p 仅包含小写字母
        public List<Integer> findAnagrams(String s, String p){
                List<Integer> res = new ArrayList<>();
                if (s.length() < p.length())  {
                        return res;
                }
                int[] count = new int[26];
                int[] count1 = new int[26];
                for (int i = 0; i < p.length(); i++) {
                        count[p.charAt(i) - 'a'] ++;
                        count1[s.charAt(i) - 'a'] ++;
                }
//                if (Arrays.equals(count, count1)) {
//                        res.add(0);
//                }
                for (int j = 1; j < s.length() - p.length()+1; j++) {
                        if (Arrays.equals(count,count1) ) {
                                res.add(j+1);
                        }
                        count1[s.charAt(j) - 'a'] --;
                        count1[s.charAt(j+p.length()) - 'a'] ++;
                }
                return res;
        }

        public static void main(String[] args) {
                System.out.println(new Solution1().findAnagrams("cbaebabacd", "abc"));
        }
}
