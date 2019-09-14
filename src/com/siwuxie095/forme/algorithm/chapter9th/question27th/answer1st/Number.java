package com.siwuxie095.forme.algorithm.chapter9th.question27th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-07-23 22:02:17
 */
public class Number {

    public static int findKthNum(int[] arr1, int[] arr2, int kth) {
        if (null == arr1 || null == arr2) {
            throw new RuntimeException("Your arr is invalid!");
        }
        if (kth < 1 || kth > arr1.length + arr2.length) {
            throw new RuntimeException("K is invalid!");
        }
        int[] longArr = arr1.length >= arr2.length ? arr1 : arr2;
        int[] shortArr = arr1.length < arr2.length ? arr1 : arr2;
        int l = longArr.length;
        int s = shortArr.length;
        if (kth <= s) {
            return getUpMedian(shortArr, 0, kth - 1, longArr, 0, kth - 1);
        }
        if (kth > l) {
            if (shortArr[kth - l -1] >= longArr[l - 1]) {
                return shortArr[kth - l - 1];
            }
            if (longArr[kth - l - 1] >= shortArr[s - 1]) {
                return longArr[kth - s - 1];
            }
            return getUpMedian(shortArr, kth - 1, s - 1, longArr, kth - s, l - 1);
        }
        if (longArr[kth - s - 1] >= shortArr[s - 1]) {
            return longArr[kth - s - 1];
        }
        return getUpMedian(shortArr, 0, s - 1, longArr, kth - s, kth - 1);
    }

    private static int getUpMedian(int[] a1, int s1, int e1, int[] a2, int s2, int e2) {
        int mid1 = 0;
        int mid2 = 0;
        int offset = 0;
        while (s1 < e1) {
            mid1 = (s1 + e1) / 2;
            mid2 = (s2 + e2) / 2;
            offset = ((e1 - s1 + 1) & 1) ^ 1;
            if (a1[mid1] > a2[mid2]) {
                e1 = mid1;
                s2 = mid2 + offset;
            } else if (a1[mid1] < a2[mid2]) {
                s1 = mid1 = offset;
                e2 = mid2;
            } else {
                return a1[mid1];
            }
        }
        return Math.min(a1[s1], a2[s2]);
    }

}
