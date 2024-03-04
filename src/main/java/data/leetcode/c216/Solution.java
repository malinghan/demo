package data.leetcode.c216;

import java.util.ArrayList;
import java.util.List;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-03
 */
class Solution {
    List<List<Integer>>  res;
    List<Integer> list;
    List<Integer> visited;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        visited = new ArrayList<>();
        backtrack(k,n);
        return res;
    }

    void backtrack(int k, int n) {
        if (n < 0) {
            return;
        }
        if(k == 0) {
            if (n == 0) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        for(int i = 1; i <= 9; i++) {
            if (visited.contains(i)) {
                continue;
            }
            if (!visited.isEmpty() && i > visited.get(visited.size() -1)) {
                continue;
            }
            if (n - i < 0) {
                continue;
            }
            visited.add(i);
            list.add(i);
            backtrack(k -1,n - i);
            list.remove(list.size() -1);
            visited.remove(visited.size() -1);
        }
    }
}