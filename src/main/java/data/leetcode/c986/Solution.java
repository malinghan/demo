package data.leetcode.c986;

import java.util.ArrayList;
import java.util.List;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-26
 *
 * 因为firstList和secondList内部是没有交集的，所以，他俩计算出来的交集是不会重叠的
 * 遍历时需要先移动的是右边界小的
 */
public class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int  i = 0;
        int j = 0;
        List<int[]> result = new ArrayList<>();
        int[] currentInterval = new int[2];
//        currentInterval = firstList[0][0] < secondList[0][0] ? firstList[0] : secondList[]
        while (i < firstList.length && j < secondList.length) {
            //重叠判断法
            // [1,3] [2,4]  -> [2,3]
            // [1,3] [2,3] -> [2,3]
            int l = Math.max(secondList[j][0], firstList[i][0]);
            int r = Math.min(secondList[j][1], firstList[i][1]);
            if (l < r) {
                result.add(new int[]{l,r});
            }
            //为何是右边界判断而不是左边界判断？
            if(firstList[i][1] < secondList[j][1]) {
                i++;
            } else {
               j++;
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}
