package com.siwuxie095.forme.algorithm.chapter5th.question20th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-05-11 17:26:34
 */
public class Length {

    public static int minLength(String str1, String str2) {
        if (null == str1 || null == str2 || str1.length() < str2.length()) {
            return 0;
        }
        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str2.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i != charArr2.length; i++) {
            map[charArr2[i]]++;
        }
        int left = 0;
        int right = 0;
        int match = charArr2.length;
        int minLen = Integer.MAX_VALUE;
        while (right != charArr1.length) {
            map[charArr1[right]]--;
            if (map[charArr1[right]] >= 0) {
                match--;
            }
            if (match == 0) {
                while (map[charArr1[left]] < 0) {
                    map[charArr1[left++]]++;
                }
                minLen = Math.min(minLen, right - left + 1);
                match++;
                map[charArr1[left++]]++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

}
