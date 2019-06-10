package com.siwuxie095.forme.algorithm.chapter8th.question10th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-05-28 23:00:18
 */
public class Length {

    public static int getMaxLength(int[] arr, int k) {
        if (null == arr || arr.length == 0 || k <= 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = arr[0];
        int len = 0;
        while (right < arr.length) {
            if (sum == k) {
                len = Math.max(len, right - left + 1);
                sum -= arr[left++];
            } else if (sum < k) {
                right++;
                if (right == arr.length) {
                    break;
                }
                sum += arr[right];
            } else {
                sum -= arr[left++];
            }
        }
        return len;
    }

}
