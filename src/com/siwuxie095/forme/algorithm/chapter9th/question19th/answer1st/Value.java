package com.siwuxie095.forme.algorithm.chapter9th.question19th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-07-07 21:37:08
 */
public class Value {

    public static int getMin(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while (low < high) {
            if (low == high - 1) {
                break;
            }
            if (arr[low] < arr[high]) {
                return arr[low];
            }
            mid = (low + high) / 2;
            if (arr[low] > arr[mid]) {
                high = mid;
                continue;
            }
            if (arr[mid] > arr[high]) {
                low = mid;
                continue;
            }
            while (low < mid) {
                if (arr[low] == arr[mid]) {
                    low++;
                } else if (arr[low] < arr[mid]) {
                    return arr[low];
                } else {
                    high = mid;
                    break;
                }
            }
        }
        return Math.min(arr[low], arr[high]);
    }

}
