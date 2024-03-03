package data.leetcode.c347;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-03
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequentMap = new HashMap<>();
        int[] res = new int [k];
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            frequentMap.putIfAbsent(nums[i], 0);
            //TODO 这样修改是否能生效
            frequentMap.put(nums[i], frequentMap.get(nums[i])+1);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(k, (o1, o2) -> (o1[1] - o2[1]));
        //其中出现频率前 k 高的元素
        for(Integer key: frequentMap.keySet()) {
            if (queue.size() < k) {
                queue.offer(new int[]{key, frequentMap.get(key)});
            } else {
                if (frequentMap.get(key) > queue.peek()[1]) {
                    queue.poll();
                    queue.offer(new int[]{key, frequentMap.get(key)});
                }
            }
        }
        int i = 0;
        while(!queue.isEmpty()) {
            res[i] = queue.poll()[0];
            i++;
        }
        return res;
    }
}
