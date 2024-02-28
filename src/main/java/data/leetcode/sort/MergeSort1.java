package data.leetcode.sort;

import java.util.Arrays;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-28
 */
public class MergeSort1 {
        public static void mergeSort(int[] array) {
            if (array == null || array.length <= 1) {
                return; // 不需要排序
            }

            int[] tempArray = new int[array.length]; // 用于存放临时结果的数组
            mergeSort(array, tempArray, 0, array.length - 1);
        }

        private static void mergeSort(int[] array, int[] tempArray, int left, int right) {
            if (left < right) {
                int mid = left + (right - left) / 2; // 计算中间位置
                mergeSort(array, tempArray, left, mid); // 对左半部分进行排序
                mergeSort(array, tempArray, mid + 1, right); // 对右半部分进行排序
                merge(array, tempArray, left, mid, right); // 合并左右两个已排序的子数组
            }
        }

        private static void merge(int[] array, int[] tempArray, int left, int mid, int right) {
            int leftEnd = mid;
            int rightStart = mid + 1;
            int leftIndex = left;
            int rightIndex = rightStart;
            int tempIndex = left;

            // 依次从左右两个子数组中选取较小的元素放入临时数组中
            while (leftIndex <= leftEnd && rightIndex <= right) {
                if (array[leftIndex] <= array[rightIndex]) {
                    tempArray[tempIndex++] = array[leftIndex++];
                } else {
                    tempArray[tempIndex++] = array[rightIndex++];
                }
            }

            // 将剩余的元素复制到临时数组中
            while (leftIndex <= leftEnd) {
                tempArray[tempIndex++] = array[leftIndex++];
            }

            while (rightIndex <= right) {
                tempArray[tempIndex++] = array[rightIndex++];
            }

            // 将临时数组中的结果复制回原数组
            for (int i = left; i <= right; i++) {
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