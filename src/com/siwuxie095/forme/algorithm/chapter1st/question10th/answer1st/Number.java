package com.siwuxie095.forme.algorithm.chapter1st.question10th.answer1st;

import java.util.LinkedList;

/**
 * @author Jiajing Li
 * @date 2019-02-09 22:12:29
 */
public class Number {

    /**
     * 子数组相当于一个窗口，子数组变化，相当于窗口滑动
     */

    public static int getNum(int[] arr, int num) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        // 维护子数组中最大值的双端队列，里面存的是最大值对应的索引
        LinkedList<Integer> qmax = new LinkedList<>();
        // 维护子数组中最小值的双端队列，里面存的是最小值对应的索引
        LinkedList<Integer> qmin = new LinkedList<>();
        int i = 0;
        int j = 0;
        int res = 0;
        /*
         * 对数组进行遍历，以 arr[i] 作为子数组的第一个元素
         *
         * 以 arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}，num = 5 为例：
         * 第一轮循环时，直到 j = 6 跳出循环；
         * 第二轮循环开始时，i = 1，j = 6，此时 j 不用再从 j = i = 1 处开始，因为第一轮循环后，
         * i...j 都是符合条件的，那么 i+1...j 必然也是符合条件的，所以直接从 j+1 处开始判断即可。
         *
         * 依此类推 ...
         */
        while (i < arr.length) {
            // 索引 j 不断向右延展
            while (j < arr.length) {
                // 对于每一个子数组，始终保证 qmax 队头元素是最大的
                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]) {
                    qmax.pollLast();
                }
                qmax.addLast(j);
                // 对于每一个子数组，始终保证 qmin 队头元素是最小的
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
                    qmin.pollLast();
                }
                qmin.addLast(j);
                // 取 qmax 和 qmin 的队头元素相减，也就是当前子数组的最大值减最小值，如果不满足条件，跳出去
                if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
                    break;
                }
                j++;
            }

            // 跳出后，qmax 的最大值 = i，则出队最大值，因为下一次 i+1 后，i 对应的元素已经不在新的子数组中了
            if (qmax.peekFirst() == i) {
                qmax.pollFirst();
            }
            // 跳出后，qmin 的最小值 = i，则出队最小值，因为下一次 i+1 后，i 对应的元素已经不在新的子数组中了
            if (qmin.peekFirst() == i) {
                qmin.pollFirst();
            }

            // 计算数量，累加得到最终结果
            res += j - i;
            i++;
        }
        return res;
    }

}
