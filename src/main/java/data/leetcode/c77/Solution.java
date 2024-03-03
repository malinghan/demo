package data.leetcode.c77;

import java.util.ArrayList;
import java.util.List;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-03
 */
class Solution {
    List<List<Integer>> res;
    List<Integer> list;
    List<Integer> visited;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        list = new ArrayList<>();
        visited = new ArrayList<>();
        backtrack(n, k);
        return res;
    }

    void backtrack(int n, int len) {
        if (list.size() == len) {
            res.add(new ArrayList<>(list));
            return;
        }
        ;
        for(int i = 1; i <= n; i++) {
            if (visited.contains(i)) {
                continue;
            }
            if (!visited.isEmpty() && visited.get(visited.size()-1) > i) {
                continue;
            }
            list.add(i);
            visited.add(i);
            backtrack(n, len);
            list.remove(list.size() -1);
            visited.remove(visited.size() -1);
        }
    }
}