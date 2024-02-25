import java.util.Arrays;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2022-03-30
 */

public class Demo {
    public static  void main(String[] args) {
//        int[] arr = new int[]{0 ,1 ,0 ,-1 ,0 ,3, 0 ,6};
//        int[] arr = new int[]{0 ,0 ,0 ,0 ,0 ,0, 0 ,0};
//        int[] arr = new int[]{10 ,10 ,10 ,10 ,10 ,10, 10 ,10};
//        int[] arr = new int[]{1 ,0 ,0 ,0 ,0 ,0, 0 ,1};
          int[] arr = new int[]{1};
          new Demo().moveZero(arr);
        System.out.println(Arrays.toString(arr));
    }
    //0 1 0 -1 0 3 0 6
    //0 1 0 0 0 -1 3 6
    public void moveZero(int[] arr) {
        int n = arr.length;
        int i = n-1, j = n-1;
        while(i >=0) {
            if (arr[i] != 0) {
                swap(arr, i, j);
                j--;
            }
            i--;
        }
    }

    private void swap(int[] arr , int i , int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
