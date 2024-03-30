package data.leetcode.sort;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-24
 */
public class QuickSort {

    public static void quickSort(int[] array) {
            quickSort(array, 0 , array.length-1);
    }

    public static void quickSort(int[] array, int l , int r) {
            if (l > r) {
                return;
            }
            int index = helper(array, l , r);
            quickSort(array, l , index-1);
            quickSort(array, index + 1, r);
    }

    private static int helper(int[] array, int l, int r) {
          int k = array[r];
          int i = l;
          int j = r-1;
          while(i < j) {
              while (array[i] > k) {
                  int temp  = array[i];
                  array[i] = array[j];
                  array[j] = temp;
                  j--;
              }
              i++;
          }
          return i;
    }
}
