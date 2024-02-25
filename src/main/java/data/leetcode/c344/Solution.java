package data.leetcode.c344;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2023-12-01
 */
public class Solution {
    public void reverseString(char[] s) {
        int i = 0, j = s.length -1;
        while (i <= j) {
            swap(s,i,j);
            i++;
            j--;
        }
    }

    void swap(char[] s,int i , int j) {
        char t = s[i];
        s[i] = s[j];
        s[j] = t;
    }
}
