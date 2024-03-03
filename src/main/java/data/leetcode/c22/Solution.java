package data.leetcode.c22;

import java.util.ArrayList;
import java.util.List;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-03
 */
class Solution {
    List<String> res;
    StringBuilder s;
    public List<String> generateParenthesis(int n) {
        //3个( 3个(
        res = new ArrayList<>();
        s = new StringBuilder("");
        backtrack(n, 0,0, 0);
        return res;
    }
    //剪zhi
    void backtrack(int n, int countLeft, int countRight, int index) {
        if (s.length() == 2 *n) {
            res.add(s.toString());
            return;
        }
        if (index == 2 * n) {
            return;
        }
        if(countLeft < n) {
            s.append("(");
            backtrack(n, countLeft+1, countRight, index+1);
            s.deleteCharAt(s.length() -1);
        }
        if (countRight < n && countLeft > countRight) {
            s.append(")");
            backtrack(n, countLeft, countRight+1, index+1);
            s.deleteCharAt(s.length() -1);
        }
    }
}