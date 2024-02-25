package data.leetcode.c438;

import java.util.ArrayList;
import java.util.List;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2023-12-06
 */
public class Solution {
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
                for (int i = 0; i < p.length(); i++) {
                        count[p.charAt(i) - 'a']++;
                }
                for (int j = 0; j < s.length() - p.length() + 1; j++) {
                        if (isAnagrams(s, p.length(), j, count)) {
                                res.add(j);
                        }
                }
                return res;
        }

        boolean isAnagrams(String s, int len, int i ,final int[] count) {
                // 0 1 2
                int[] count1 = new int[26];
                for (int m = 0;  m < len; m++) {
                        count1[s.charAt(m+i) - 'a']++;
                }
                for (int j = 0; j < 26; j++) {
                        if (count[j] != count1[j]) {
                                return false;
                        }
                }
                return true;
        }

        public static void main(String[] args) {
                System.out.println(new Solution().findAnagrams("cbaebabacd", "abc"));
        }
}
