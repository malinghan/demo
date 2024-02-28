package data.leetcode.c215;

import java.util.Random;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-28
 * 这段代码首先检查输入是否有效，然后调用 quickSelect 方法进行查找。
 * quickSelect 方法中，我们首先随机选择一个元素作为pivot，并通过 partition
 * 方法将数组分成两部分。然后，根据pivot的位置和k的大小，递归地在其中一部分进行查找。
 * partition 方法通过设定一个pivot值，将数组分成两部分，左边的部分包含比pivot小的元素，右边的部分包含比pivot大的元素。
 *
 * 在 main 方法中，我们提供了一个示例数组，并查找第2个最大元素
 */
public class Solution1 {

    public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length) {
            throw new IllegalArgumentException("Invalid input");
        }

        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private static int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }

        Random random = new Random();
        int pivotIndex = left + random.nextInt(right - left + 1);
        pivotIndex = partition(nums, left, right, pivotIndex);

        if (k == pivotIndex) {
            return nums[k];
        } else if (k < pivotIndex) {
            return quickSelect(nums, left, pivotIndex - 1, k);
        } else {
            return quickSelect(nums, pivotIndex + 1, right, k);
        }
    }

    private static int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivotValue = nums[pivotIndex];
        swap(nums, pivotIndex, right);
        int storeIndex = left;

        for (int i = left; i < right; i++) {
            if (nums[i] < pivotValue) {
                swap(nums, i, storeIndex);
                storeIndex++;
            }
        }

        swap(nums, storeIndex, right);
        return storeIndex;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int result = findKthLargest(nums, k);
        System.out.println("The " + k + "th largest element is: " + result);
    }
}
