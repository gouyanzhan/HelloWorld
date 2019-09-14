package com.siwuxie095.forme.algorithm.chapter9th.question33th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-07-28 12:03:38
 */
public class Solution {

    public static int solution1(int[] arr, int num) {
        if (null == arr || arr.length == 0 || num < 1) {
            throw new RuntimeException("err");
        }
        int[] sumArr = new int[arr.length];
        int[] map = new int[arr.length];
        sumArr[0] = arr[0];
        map[0] = arr[0];
        for (int i = 1; i < sumArr.length; i++) {
            sumArr[i] = sumArr[i - 1] + arr[i];
            map[i] = sumArr[i];
        }
        for (int i = 1; i < num; i++) {
            for (int j = map.length - 1; j > i - 1; j--) {
                int min = Integer.MAX_VALUE;
                for (int k = i - 1; k < j; k++) {
                    int cur = Math.max(map[k], sumArr[j] - sumArr[k]);
                    min = Math.min(min, cur);
                }
                map[j] = min;
            }
        }
        return map[arr.length - 1];
    }

    public static int solution2(int[] arr, int num) {
        if (null == arr || arr.length == 0 || num < 1) {
            throw new RuntimeException("err");
        }
        int[] sumArr = new int[arr.length];
        int[] map = new int[arr.length];
        sumArr[0] = arr[0];
        map[0] = arr[0];
        for (int i = 1; i < sumArr.length; i++) {
            sumArr[i] = sumArr[i - 1] + arr[i];
            map[i] = sumArr[i];
        }
        int[] cands = new int[arr.length];
        for (int i = 1; i < num; i++) {
            for (int j = map.length - 1; j > i - 1; j--) {
                int minPar = cands[j];
                int maxPar = j == map.length - 1 ? j : cands[j + 1];
                int min = Integer.MAX_VALUE;
                for (int k = minPar; k < maxPar + 1; k++) {
                    int cur = Math.max(map[k], sumArr[j] - sumArr[k]);
                    if (cur < min) {
                        min = cur;
                        cands[j] = k;
                    }
                }
                map[j] = min;
            }
        }
        return map[arr.length - 1];
    }

    private static int getNeedNum(int[] arr, int lim) {
        int res = 1;
        int stepSum = 0;
        for (int i = 0; i != arr.length; i++) {
            if (arr[i] > lim) {
                return Integer.MAX_VALUE;
            }
            stepSum += arr[i];
            if (stepSum > lim) {
                res++;
                stepSum = arr[i];
            }
        }
        return res;
    }

    public static int solution3(int[] arr, int num) {
        if (null == arr || arr.length == 0 || num < 1) {
            throw new RuntimeException("err");
        }
        if (arr.length < num) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i != arr.length; i++) {
                max = Math.max(max, arr[i]);
            }
            return max;
        } else {
            int minSum = 0;
            int maxSum = 0;
            for (int i = 0; i != arr.length; i++) {
                maxSum += arr[i];
            }
            while (minSum != maxSum - 1) {
                int mid = (minSum + maxSum) / 2;
                if (getNeedNum(arr, mid) > num) {
                    minSum = mid;
                } else {
                    maxSum = mid;
                }
            }
            return maxSum;
        }
    }

}
