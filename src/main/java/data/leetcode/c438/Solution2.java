package data.leetcode.c438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2023-12-06
 * 另一种下标的判断方式
 */
public class Solution2 {
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
        // a b c d e f   def
        //注意这里边界条件的判断
        for (int j = 0; j + p.length()-1 < s.length(); j++) {
            if (Arrays.equals(count,count1) ) {
                res.add(j);
            }
            if (j != s.length() - p.length()) {
                count1[s.charAt(j) - 'a'] --;
                count1[s.charAt(j+p.length()) - 'a'] ++;
            }
        }
        return res;
    }
}
