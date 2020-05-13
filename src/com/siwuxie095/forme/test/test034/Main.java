package com.siwuxie095.forme.test.test034;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Jiajing Li
 * @date 2020-05-13 10:28:50
 */
public class Main {

    /**
     * 说明的问题：
     * 1、测试按字典序生成 N 位无重复字符的全排列（时间复杂度 N * (N+1) * (3 / 2)）；
     */
    public static void main(String[] args) {
        String[] strArr = new String[] {"A", "B", "C", "D", "E", "F", "G"};
        List<String[]> groupList = new ArrayList<>();
        getAllPermutation(strArr, groupList);
        for (String[] group : groupList) {
            Arrays.stream(group).forEach(System.out::print);
            System.out.println();
        }
    }

    private static void getAllPermutation(String[] strArr, List<String[]> groupList) {
        int count = 1;
        for (int i = 2; i <= strArr.length; i++) {
            count *= i;
        }
        groupList.add(Arrays.copyOf(strArr, strArr.length));
        for (int i = 0; i < count - 1; i++) {
            getNextPermutation(strArr);
            String[] group = Arrays.copyOf(strArr, strArr.length);
            groupList.add(group);
        }
    }

    private static void getNextPermutation(String[] strArr) {
        for (int i = strArr.length - 2; i >= 0; i--) {
            if (strArr[i].compareTo(strArr[i + 1]) < 0) {
                for (int j = strArr.length - 1; j > i; j--) {
                    if (strArr[i].compareTo(strArr[j]) < 0) {
                        swap(strArr, i, j);
                        reverse(strArr, i + 1, strArr.length);
                        return;
                    }
                }
            }
        }
        // 特别的，数组已经从大到小排列好，reverse数组得到下一个排列
        reverse(strArr, 0, strArr.length);
    }

    private static void reverse(String[] arr, int startIndexInclusive, int endIndexExclusive) {
        if (null == arr) {
            return;
        }
        int i = Math.max(0, startIndexInclusive);
        int j = Math.min(arr.length, endIndexExclusive) - 1;
        while (j > i) {
            swap(arr, i, j);
            j--;
            i++;
        }
    }

    private static void swap(String[] arr, int i, int j) {
        String tmp;
        tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

}
