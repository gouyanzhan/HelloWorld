package com.siwuxie095.forme.test.test035;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jiajing Li
 * @date 2020-05-13 14:03:25
 */
public class Main {

    /**
     * 说明的问题：
     * 1、测试使用回溯法生成 N 位无重复字符的全排列（非字典序，时间复杂度 N^2）；
     */
    public static void main(String[] args) {
        String[] strArr = new String[] {"A", "B", "C", "D", "E", "F", "G"};
        List<String[]> groupList = new ArrayList<>();
        getAllPermutation(strArr, 0, strArr.length, groupList);
        for (String[] group : groupList) {
            Arrays.stream(group).forEach(System.out::print);
            System.out.println();
        }
    }

    /**
     * 首先选择第一位的元素，选择方法：与第一位后面的元素进行交换。（for 循环和第一个 swap 控制）
     * 其次选择第二位的元素，选择方法：与第二位后面的元素进行交换。（递归调用 getAllPermutation）
     * ...
     *
     * 注意：递归返回时，需要把交换过的变量交换回来，进行还原。（第二个 swap 控制）
     */
    private static void getAllPermutation(String[] strArr, int startIdx, int length, List<String[]> groupList) {
        //if (startIdx == length) {
        //    return;
        //}
        if (startIdx == length - 1) {
            String[] group = strArr.clone();
            groupList.add(group);
            return;
        }
        for(int currentIdx = startIdx; currentIdx < length; currentIdx++) {
            swap(strArr, startIdx, currentIdx);
            getAllPermutation(strArr,startIdx + 1 , length, groupList);
            swap(strArr, startIdx, currentIdx);
        }
    }

    private static void swap(String[] arr, int i, int j) {
        String tmp;
        tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

}
