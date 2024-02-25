package data.leetcode.c1;

import java.util.HashMap;
import java.util.Map;

/**
 * 复杂度：
 * 思路:  哈希map，记录key和value
 */
public class TwoSum2 {
    //给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
    //
    //你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
    //
    //你可以按任意顺序返回答案。
    public int[] twoSum(int [] nums, int target) {
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int remains = target - nums[i];
            if (map.containsKey(remains)) {
//                res[0] = map.get(remains);
//                res[1] = i;
//                return res;
                return new int[]{map.get(remains), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println("hello");
    }
    //1. 为什么排序是int[]{map.get(remains), i};， 而不是 int[]{i, map.get(remains)}？
    //和遍历的顺序有关，map.put(nums[i], i) 相当于把前者先放在map里面当作判断和查找的依据
    //2. 为什么只需要1遍遍历，不怕漏吗？
    //A: 因为题目只要求找到一对即可，且遍历是有序的，map.containsKey 相当于是把之前的都匹配一遍，所以可以做到不漏
}