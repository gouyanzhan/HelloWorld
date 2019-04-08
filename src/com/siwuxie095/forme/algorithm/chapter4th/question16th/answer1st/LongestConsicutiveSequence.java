package com.siwuxie095.forme.algorithm.chapter4th.question16th.answer1st;

import java.util.HashMap;

/**
 * @author Jiajing Li
 * @date 2019-04-08 16:19:45
 */
public class LongestConsicutiveSequence {

    public static int longestConsecutiveSequence(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        int max = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; ++i) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
                if (map.containsKey(arr[i] - 1)) {
                    max = Math.max(max, merge(map, arr[i] - 1, arr[i]));
                }
                if (map.containsKey(arr[i] + 1)) {
                    max = Math.max(max, merge(map, arr[i], arr[i] + 1));
                }
            }
        }
        return max;
     }

    private static int merge(HashMap<Integer, Integer> map, int less, int more) {
        int left  = less - map.get(less) + 1;
        int right = more + map.get(more) - 1;
        int len = right - left + 1;
        map.put(left, len);
        map.put(right, len);
        return len;
    }

}
