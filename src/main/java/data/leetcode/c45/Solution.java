package data.leetcode.c45;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-07
 * 跳跃游戏II
 * 贪心算法
 * 最优题解：https://leetcode.cn/problems/jump-game-ii/solutions/36035/45-by-ikaruga/?envType=study-plan-v2&envId=top-100-liked
 *
 *
 * 记录 end 和 maxPostion
 */
public class Solution {
    //最小跳跃次数
    public int jump(int[] nums) {
        int n = nums.length;
        //当前能跳跃的最远位置的边界下标
        int end = 0;
        //在边界范围内，能跳跃的最远位置的下标
        int maxPosition = 0;
        //所需步数
        int steps = 0;
        //最后一步为啥不能到达？因为到达n-1位置时不需要step++
        for (int i = 0; i < n -1; i++) {
            //每走一步都更新最远位置的下标，计算到边界之前的能跳的最优位置的下标
            maxPosition = Math.max(maxPosition, i + nums[i]);
            //判断i~maxPosition
            //如果到达边界，说明要进行下一次跳跃，此时steps++, end = maxPostion
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
