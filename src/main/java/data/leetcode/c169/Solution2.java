package data.leetcode.c169;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-09
 */
public class Solution2 {
        public int majorityElement(int[] nums) {
            //二分？
            //投票
            //1. 哈希表
            //2. 排序取中位数
            //3. 随机取值
            //*4. 分治法
            //5. 投票法

            //分治法原理: 设a为nums众数，如果将nums分成2部分，那么a必定至少是一部分的众数
            //算法过程:
            // 1. 长度为1的2个子数组，显然为子数组中的众数
            // 2. 长度大于1的2个子数组，需要将其合并，设left right为左右2个子数组的重数
            //     如果left == right，则直接合并
            //     如果left != right, 比较left和right，在合并区间的次数 leftCount rightCount
            // 3. 如果 leftCount > rightCount  合并之后的众数为leftCount
            // 4. 如果 leftCount < rightCount  合并之后的众数为rightCount
            // 5. 如果 leftCount < rightCount  都行，就设为rightCount [因为总有一个子数组是整个数组的众数]

            //算法采用二分迭代的算法来写
            return majorityElementRec(nums, 0 , nums.length -1);
        }

        public int majorityElementRec(int[] nums, int l , int r) {
            // base case; the only element in an array of size 1 is the majority element.
            if (l == r) {
                return nums[l];
            }
            // recurse on left and right halves of this slice.
            int mid = l + (r - l ) /2;
            int left = majorityElementRec(nums, l, mid);
            int right = majorityElementRec(nums, mid+1,r);
            // if the two halves agree on the majority element, return it.
            if (left == right) {
                return left;
            }
            // otherwise, count each element and return the "winner".
            int leftCount = countInRange(nums, left, l, r);
            int rightCount = countInRange(nums, right, l, r);
            return leftCount > rightCount ? left : right;
        }

        private int countInRange(int[] nums, int candidate, int l , int r) {
            int count = 0;
            for(int i = l ; i <= r; i++) {
                if (nums[i] == candidate) {
                    count++;
                }
            }
            return count;
        }
}
