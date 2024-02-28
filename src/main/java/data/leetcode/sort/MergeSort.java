package data.leetcode.sort;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-28
 */
import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return; // 不需要排序
        }

        int n = array.length;
        int[] tempArray = new int[n]; // 用于存放临时结果的数组

        for (int size = 1; size < n; size *= 2) { // size为归并的子数组大小
            for (int leftStart = 0; leftStart < n - 1; leftStart += 2 * size) {
                int mid = Math.min(leftStart + size - 1, n - 1); // 计算中间位置
                int rightEnd = Math.min(leftStart + 2 * size - 1, n - 1); // 计算右边界
                merge(array, tempArray, leftStart, mid, rightEnd); // 合并左右两个子数组
            }
        }
    }

    private static void merge(int[] array, int[] tempArray, int leftStart, int mid, int rightEnd) {
        int leftEnd = mid;
        int rightStart = mid + 1;
        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        // 依次从左右两个子数组中选取较小的元素放入临时数组中
        while (left <= leftEnd && right <= rightEnd) {
            if (array[left] <= array[right]) {
                tempArray[index++] = array[left++];
            } else {
                tempArray[index++] = array[right++];
            }
        }

        // 将剩余的元素复制到临时数组中
        while (left <= leftEnd) {
            tempArray[index++] = array[left++];
        }

        while (right <= rightEnd) {
            tempArray[index++] = array[right++];
        }

        // 将临时数组中的结果复制回原数组
        for (int i = leftStart; i <= rightEnd; i++) {
            array[i] = tempArray[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};
        System.out.println("原始数组：" + Arrays.toString(array));
        mergeSort(array);
        System.out.println("排序后数组：" + Arrays.toString(array));
    }
}
