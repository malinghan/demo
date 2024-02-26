package data.leetcode.c238;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-26
 */
public class Solution {
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
        for(int j = n-2;  j >= 0 ; j--) {
            post[j] = post[j+1] * nums[j+1];
        }
        for(int k = 0; k < n ; k++) {
            res[k] = prev[k] * post[k];
        }
        return res;
    }
}
