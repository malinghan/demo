package data.leetcode.c1288;

import java.util.Arrays;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-26
 */
public class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            } else {
                return  o1[0] - o2[0];
            }
        });
         int count = 0;
         int currentEnd = Integer.MIN_VALUE;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] > currentEnd) {
                currentEnd = intervals[i][1];
                count++;
            }
        }
        return count;
    }
}
