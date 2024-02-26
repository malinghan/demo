package data.leetcode.c189;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-26
 * 环状替换
 */
public class Solution1 {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(n, k); // 计算最大公约数，用于确定替换轮数

        for (int start = 0; start < count; start++) {
            int current = start;
            int prev = nums[start];

            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current); // 回到起始位置，结束替换
        }
    }

    // 计算最大公约数
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, k);
        System.out.println("轮转后的数组为: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
