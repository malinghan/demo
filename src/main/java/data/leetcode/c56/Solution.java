package data.leetcode.c56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-26
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        //先按左边界排序
        Arrays.sort(intervals, (o1,o2) -> (o1[0] - o2[0]));
        //使用 List<int[][]> 临时存放比较结果
        List<int[]> result = new ArrayList<>();
        int[] currentInterval = intervals[0];
        result.add(currentInterval);
        //再分条件讨论是否需要合并
        for (int i = 1; i < intervals.length; i++) {
            int currentEnd = currentInterval[1];
            int nextBegan = intervals[i][0];
            int nextEnd = intervals[i][1];
            //区间判断，1，是否重叠
            if (nextBegan <= currentEnd) {
                //重叠可以进行合并
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
               //2，不重叠,进行下一轮判断
                currentInterval = intervals[i];
                result.add(currentInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] mergedIntervals = new Solution().merge(intervals);
        System.out.println("合并后的区间:");
        for (int[] interval : mergedIntervals) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
