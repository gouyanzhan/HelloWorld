package com.siwuxie095.forme.algorithm.chapter1st.question7th.answer1st;

import java.util.LinkedList;

/**
 * @author Jiajing Li
 * @date 2019-02-08 16:11:56
 */
public class MaxWindow {

    /**
     * 注意：
     * peekLast() 表示获取最后一个元素，但是不移除
     * pollLast() 获取最后一个元素并移除
     */

    public static int[] getMaxWindow(int[] arr, int w) {
        if (null == arr ||  w < 1 || arr.length < w) {
            return null;
        }
        // 使用 LinkedList 作为双端队列
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; ++i) {
            // qmax 不为空，且队尾对应下标的数组元素小于等于当前遍历的数组元素，队尾做出队操作
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            // qmax 为空 或 队尾对应下标的数组元素大于当前遍历的数组元素，队尾做入队操作
            qmax.addLast(i);
            // 队头对应下标等于 i - w，队头做出队操作
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

}
