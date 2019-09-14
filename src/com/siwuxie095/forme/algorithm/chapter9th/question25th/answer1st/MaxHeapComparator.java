package com.siwuxie095.forme.algorithm.chapter9th.question25th.answer1st;

import java.util.Comparator;

/**
 * 生成大根堆的比较器
 *
 * @author Jiajing Li
 * @date 2019-07-21 23:25:51
 */
public class MaxHeapComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        if (o2 > o1) {
            return 1;
        } else {
            return -1;
        }
    }
}
