package data.leetcode.sort;

import java.util.Arrays;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-02-28
 */
public class MyMergeSort1 {
    public static void mergeSort(int[] array) {
        if (array == null || array.length == 1) {
            return;
        }
        int n = array.length;
        int[] tempArr = new int[n];
        doMergeSort(array, tempArr, 0 , n-1);
    }

    public static void doMergeSort(int[] array, int[] tempArr, int leftStart, int rightEnd) {
        if (leftStart < rightEnd) {
            int mid = leftStart + (rightEnd - leftStart) / 2;
            doMergeSort(array, tempArr, leftStart, mid);
            doMergeSort(array, tempArr, mid + 1, rightEnd);
            merge(array, tempArr, leftStart, mid, rightEnd);
        }
    }

    public static void merge(int[] array, int[] tempArr, int leftStart, int mid,int rightEnd) {
        int leftEnd = mid;
        int rightStart = mid +1;
        int left = leftStart;
        int right = rightStart;
        int index = leftStart;
        while (left <= leftEnd && right <= rightEnd) {
            if (array[left] <= array[right]) {
                tempArr[index] = array[left];
                left ++;
            } else {
                tempArr[index] = array[right];
                right++;
            }
            index++;
        }
        while (left <= leftEnd) {
            tempArr[index] = array[left];
            index++;
            left++;
        }
        while (right <= rightEnd) {
            tempArr[index] = array[right];
            index++;
            right++;
        }
        //复制排序后的数组到原数组
        for( int i = leftStart; i <= rightEnd; i++) {
            array[i] = tempArr[i];
        }
    }

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};
        System.out.println("原始数组：" + Arrays.toString(array));
        mergeSort(array);
        System.out.println("排序后数组：" + Arrays.toString(array));
    }
}
