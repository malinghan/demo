package data.leetcode.c17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-03
 */
class Solution {
    List<String> res;
    public List<String> letterCombinations(String digits) {
        Map<String, String> map = new HashMap<>();
        res = new ArrayList<String>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        //易错点1: digits == "" 应该写成  digits.equals("")
        //    if (digits.equals("")) {
        if (digits.length() == 0) {
            return res;
        }
        backtrack(map, digits, 0);
        return res;
    }
    //逐层遍历的关键代码 1: 函数定义 index 2: 递归时 index+1  3. 入口处判断边界，避免index超过
    StringBuilder s = new StringBuilder("");
    //易错点2: 需要传入index,表示level
    void backtrack(Map<String, String> map, String digits, int index) {
        if(s.length() == digits.length()) {
            res.add(s.toString());
            //易错点5: 这里需要return, 否则index会越界
            return;
        }
        String number = String.valueOf(digits.charAt(index));
        String words = map.get(number);
        //易错点3:不需要标记和判断已走过的元素，因为每一层的值都不一样，都是从0开始走
        for (int j = 0; j < words.length(); j++) {
            s.append(words.charAt(j));
            backtrack(map, digits, index+1);
            //易错点4:StringBuilder API删除最后一个节点的函数为 deleteCharAt
            s.deleteCharAt(s.length()-1);
        }
    }
}