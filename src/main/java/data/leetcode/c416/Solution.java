package data.leetcode.c416;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-07
 */
class Solution {
    public boolean canPartition(int[] nums) {
        //先排序
        //给定 nums[0],是否能取出一些数，使得这些数等于整个数组元素和的一边 sum /2
        //[0-1 背包问题] ？？
        //初始化判断：
        // 如 n < 2  => false
        // 计算 sum, 和 maxNum
        // 如果sum 是奇数  => false
        // 如果是偶数 target = sum/2
        // 如果 maxNum > target => false

        //给定二维数组dp，n行target+1列 boolean dp[target+1][n]
        //表示从[0,i]下标范围内选取x个数，使得 sum = j
        // 初始化 false

        //边界
        //如果不选，0 ， dp[i][0] = true;
        // i == 0, 只选择 1个数 nums[0] dp[0][nums[0]] = ture
        // i>0 j>0  dp[i][j] =
        // if: j > nums[i]  dp[i][j] = true =>

        //方程  i表示nums中挑选了元素0~i， j表示容量(sum), 是否存在
        // 不选择 nums[i]，如果在 [0, i - 1] 这个子区间内已经有一部分元素，使得它们的和为 j ，那么 dp[i][j] = true；
        //dp[i][j] = dp[i - 1][j] 不挑选nums[i]
        //or dp[i][j] = dp[i - 1][j - nums[i]] 选择nums[i]

        //初始化
        // j - nums[i] > 0   ==> nums[i] <= j
        // j == nums[j]   ==> nums[i] 就是背包的容量

        // dp[i][j] = dp[i-1][j] (if dp[i-1][j] == true)
        // dp[i][j] = true;  nums[i] = j
        //dp[i][j]  = dp[i-1][j- nums[i]]  nums[i] < j

        // dp[0][0] = false [nums[0]且target= 0]

        //结果
        // res = dp[len-1][target]

        int len  = nums.length;
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }

        int target = sum /2;

        boolean[][] dp = new boolean[len][target+1];
        //填充第0行
        //只有nums[0], 第1个数，只有容积为nums[0]的背包才能装满
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < len; i++)  {
            for(int j = 0; j <= target; j++) {
                //先把上一行的计算结果复制过来，再修正
                dp[i][j] = dp[i-1][j];
                //如果nums[i]刚好是容积j
                if( nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                //只要有一个满足即为true
                if(nums[i] < j) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i]];
                }

            }
        }
        return dp[len-1][target];
    }
}