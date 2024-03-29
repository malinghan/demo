package data.leetcode.c49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2023-12-01
 * 思路:
 * 如何迅速判断两个字符串是异位词?
 *  步骤:
 *  1. 主要是将字符串用哈希表编码(char[] code)
 *  2. 放入map<code, List<index>>
 *  3. 输出 List<map.values>
 *  如何编码？ 步骤
 * 1. 生成一个 char[26]用于存储编码 char[] count，对应于a到z
 * 2. 遍历一个字符串的字符，与 'a' 相减，转换成数字n, 根据n的值，找到count对应的下标,并记录出现的次数
 * 3. 形成字符串
 */
public class Solution {

    /**
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     *
     * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
     *
     *
     *
     * 示例 1:
     *
     * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * 示例 2:
     *
     * 输入: strs = [""]
     * 输出: [[""]]
     * 示例 3:
     *
     * 输入: strs = ["a"]
     * 输出: [["a"]]
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String strEncoder = encode(strs[i]);
            map.putIfAbsent(strEncoder, new ArrayList<>());
            map.get(strEncoder).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

   public String encode(String str) {
        char[] count = new char[26];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a'] ++;
        }
        return new String(count);
    }

    public static void main(String[] args) {
        String[] strs = {"abbbcc", "aaabbccc", "abbccccc"};
        for (int i = 0; i < strs.length; i++) {
            System.out.println(new Solution().encode(strs[i]));
        }
        //这种编码出来的字符串没有实际意义，只是用来编码字母异位分词
        //                       
        //                       
        //                       
    }
}
