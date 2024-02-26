package data.leetcode.c238;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-26
 * 计算右侧的同时，可以同时计算结果
 */
public class Solution1 {
    public int[] productExceptSelf(int[] nums) {
        int  n = nums.length;
        int[] prev = new int [n];
        int[] post = new int [n];
        int[] res = new int[n];
        prev[0] = 1;
        post[n-1] = 1;
        for(int i = 1; i < n ; i++) {
            prev[i] = prev[i-1] * nums[i-1];
        }
        res[n-1] = prev[n-1];
        for(int j = n-2;  j >= 0 ; j--) {
            post[j] = post[j+1] * nums[j+1];
            res[j] = prev[j] * post[j];
        }
        return res;
    }
}
