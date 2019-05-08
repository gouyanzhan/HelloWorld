package com.siwuxie095.forme.algorithm.chapter5th.question18th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-04-29 13:42:53
 */
public class Unique {

    public static int maxUnique(String str) {
        if (null == str || "".equals(str)) {
            return 0;
        }
        char[] charArr = str.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < 256; i++) {
            map[i] = -1;
        }
        int len = 0;
        int pre = -1;
        int cur = 0;
        for (int i = 0; i != charArr.length; i++) {
            pre = Math.max(pre, map[charArr[i]]);
            cur = i - pre;
            len = Math.max(len, cur);
            map[charArr[i]] = i;
        }
        return len;
    }

}
