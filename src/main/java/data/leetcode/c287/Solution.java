package data.leetcode.c287;

class Solution {
    public int findDuplicate(int[] nums) {
       int gui = 0;
       int tu = 0;
       int n = nums.length;
       //num[i],表示下一次要到达的数组下标
       while (true) {
           gui = nums[gui];
           tu =  nums[nums[tu]];
           if (gui == tu) {
              break;
           }
       }
       tu = 0;
       while(gui != tu) {
           tu = nums[tu];
           gui = nums[gui];
       }
       return tu;
    }
}