package data.leetcode.c2386;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author someecho <linghan.ma@gmail.com>
 * Created on 2024-03-09
 */
public class Solution1 {
    // 子序列
    class Sequence {
        long sum;       // 该子序列的和
        int tailIdx;    // 该子序列最后一个元素的下标

        public Sequence(long sum, int tailIdx) {
            this.sum = sum;
            this.tailIdx = tailIdx;
        }
    }

    /**
     *
     * 【堆】
     * 数组规模最大为：10^5
     * k 不超过 2000，不超过 2^n
     *
     * nums 中所有正数元素的和 maxSum 为最大的子序列和。
     * 所有子序列都能由这个 maxSum 对应的子序列出发，通过移除部分正数、添加部分非正数得到。
     * 因此，2^n 个子序列和都可以由 maxSum 减去部分正数元素值或加上部分负数元素值得到。
     * 我们可以将原数组中的正数和负数统一一下，全部取为正数，那么在 maxSum 上加上负数值就相当于是减去它的绝对值。
     *
     * 有了上面的转化，目标就转化为：从一个由非负元素构成的数组中求出【第 k 小的子序列和】。
     * 如果一一枚举需要 O(2^n) 的时间复杂度，我们肯定不能这样做，我们需要想出一个 O(nlogn) 的方法。
     *
     * 我们使用优先队列（小根堆）来维护当前遍历的所有子序列和。
     * 我们可以对这个非负数组做排序，并从子序列 {a[0]} 出发（它一定具有最小的【非空】子序列和），将其放入堆中，
     * 每次从堆中抛出堆顶元素（当前的最小子序列和），并在该子序列的两个「邻居节点」放入堆中。
     * 不断重复这个过程，直到抛出 k - 1 个最小子序列和即完成。
     *
     * 我们能够保证这样的做法能确保所有子序列和不被遗漏，同时一定是【sum 较小】的子序列先放入堆，【sum 较大】的子序列后放入堆。
     */
    public long kSum(int[] nums, int k) {
        int n = nums.length;
        long maxSum = 0;                    // nums 的所有子序列的最大和
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                maxSum += nums[i];
            }
            nums[i] = Math.abs(nums[i]);          // 所有元素取绝对值
        }
        Arrays.sort(nums);                          // 对不含负数的数组做排序，时间复杂度：O(nlogn)

        // 目标：在 nums 中找到和第 k 小的子序列和
        // 不能暴力地一一枚举子序列，时间复杂度会到 O(2^n)
        // 使用上面所说的枚举方法，能够在 O(klogk) 的时间复杂度内确定【前 k 小的子序列和】
        // 堆中元素数量始终不会超过 k 个（每次取出队头子序列和，并加入两个新的子序列和）
        Queue<Sequence> heap = new LinkedList<>();       // 小根堆，按照子序列的 sum 进行升序排序
        heap.offer(new Sequence(nums[0], 0));         // 我们枚举子序列的起点：和最小的【非空】子序列
        long target = 0L;         // 目标要求的【第 k 小的子序列和】，初始为 0，即第 1 小的子序列和 —— 空子序列
        while (--k > 0) {       // 只需要再抛出 k - 1 个子序列
            Sequence seq = heap.poll();
            System.out.println(seq.sum);
            long sum = seq.sum;         // 当前「子序列节点」的 sum
            int idx = seq.tailIdx;      // 当前「子序列节点」的末尾元素 idx
            target = sum;

            if (idx < n - 1) {
                heap.offer(new Sequence(sum - nums[idx] + nums[idx + 1], idx + 1));    // 待加入的新子序列：使用后一个元素替换掉当前抛出的子序列的末尾元素
                heap.offer(new Sequence(sum + nums[idx + 1], idx + 1));     // 待加入的新子序列：当前抛出的子序列后面直接加上后一个元素
                // 可以发现，我们新放入堆中的子序列和一定大于我们抛出的子序列和
            }
        }
        return maxSum - target;
    }

    public static void main(String[] args) {
        new Solution1().kSum(new int[]{-530219056, 353285209, 493533664}, 6);
        //353285209 493533664 530219056
        //353285209
        //493533664 353285209 + 493533664
        //530219056 353285209 + 530219056 493533664 + 530219056
    }
}

//

// 1 2 3
// 1 2 1 3  2 3
// 1 2 3

