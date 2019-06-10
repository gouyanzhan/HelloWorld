package com.siwuxie095.forme.algorithm.chapter8th.question9th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-05-27 17:59:51
 */
public class Print {

    public static void printUniquePair(int[] arr, int k) {
        if (null == arr || arr.length < 2) {
            return;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] < k) {
                left++;
            } else if (arr[left] + arr[right] > k) {
                right--;
            } else {
                if (left == 0 || arr[left - 1] != arr[left]) {
                    System.out.println(arr[left] + ", " + arr[right]);
                }
                left++;
                right--;
            }
        }
    }


    public static void printUniqueTriad(int[] arr, int k) {
        if (null == arr || arr.length < 3) {
            return;
        }
        for (int i = 0; i < arr.length - 2; i++) {
            if (i == 0 || arr[i] != arr[i - 1]) {
                printRest(arr, i, i + 1, arr.length - 1, k - arr[i]);
            }
        }
    }

    private static void printRest(int[] arr, int f, int l, int r, int k) {
        while (l < r) {
            if (arr[l] + arr[r] < k) {
                l++;
            } else if (arr[l] + arr[r] > k) {
                r--;
            } else {
                if (l == f + 1 || arr[l - 1] != arr[l]) {
                    System.out.println(arr[f] + ", " + arr[l] + ", " + arr[r]);
                }
                l++;
                r--;
            }
        }
    }

}
