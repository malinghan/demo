package data.leetcode.c560;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2023-12-08
 */
public class Solution1 {
    public List<List<Integer>> subarraySum(int[] nums, int k) {
        Map<Integer,List<Integer>> prefixCountMap  = new HashMap<>();
        List<Integer> initList =  new ArrayList<>();
        initList.add(0);
        prefixCountMap.put(0, initList);
        List<List<Integer>> res = new ArrayList<>();
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre = pre + nums[i];
            if (prefixCountMap.containsKey(pre - k)) {
                for (Integer integer : prefixCountMap.get(pre - k)) {
                    List<Integer> list = new ArrayList<>();
                    list.add(integer);
                    list.add(i);
                    res.add(list);
                }
            }
            List<Integer> temp = prefixCountMap.getOrDefault(pre, new ArrayList<>());
            temp.add(i+1);
            prefixCountMap.put(pre, temp);
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(new Trie().subarraySum(new int[]{-1,-1,1}, 2));
        System.out.println(new Solution1().subarraySum(new int[]{3,4,7,0,-3,1,4,2}, 7));
    }
}
