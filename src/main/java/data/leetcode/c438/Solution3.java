package data.leetcode.c438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-25
 */
public class Solution3 {
    public List<Integer> findAnagrams(String s, String p){
        int len = p.length();
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) {
            return res;
        }
        int[] countS = new int[26];
        int[] countP = new int[26];
        for(int i = 0; i < p.length(); i++) {
            countS[s.charAt(i) - 'a']++;
            countP[p.charAt(i)- 'a']++;
        }
        if (Arrays.equals(countP, countS)) {
            res.add(0);
        }
        //abca
        for (int i = 1; i < s.length() - p.length()+1; i++) {
                countS[s.charAt(i-1) - 'a']--;
                countS[s.charAt(i+len-1) - 'a']++;
            if (Arrays.equals(countP, countS)) {
                res.add(i);
            }
        }
        return res;
    }
}
