package data.leetcode.c763;

import java.util.ArrayList;
import java.util.List;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-08
 */
public class Solution {
    public List<Integer> partitionLabels(String s) {
        //根据题意：同一个字母的第一次出现和最后一次出现的下标必须是同一段
        //如果能获取到每个字母最后一次出现的下标位置，可以用贪心算法将其划分

        //开始划分第一段，设 start = end = 0
        //对于每个访问到的第一个字母c, 其最后一次出现的下标为 endC， 则 end = Max(end, endC)

        //开始划分第二段， start = end + 1， 一直到遍历完成

        //怎么证明这样划分是正确的呢？因为目标就是划分尽可能细致
        int start = 0, end  = 0;
        //step1:求出每个字母最后出现的下标
        int[] last = new int[26];
        int length = s.length();
        for(int i = 0 ; i < length; i ++) {
            last[s.charAt(i) - 'a'] = i;
        }

        //step2:开始划分
        List<Integer> partition = new ArrayList<Integer>();

        for(int i = 0; i < length; i++) {
            end  =  Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end +1;
            }
        }
        return partition;
    }
}
