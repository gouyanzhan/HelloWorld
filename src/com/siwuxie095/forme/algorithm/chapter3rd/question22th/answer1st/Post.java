package com.siwuxie095.forme.algorithm.chapter3rd.question22th.answer1st;

import java.util.HashMap;

/**
 * @author Jiajing Li
 * @date 2019-03-31 13:34:39
 */
public class Post {

    public static int[] getPostArray(int[] preArr, int[] inArr) {
        if (null == preArr || null == inArr) {
            return null;
        }
        int len = preArr.length;
        int[] postArr = new int[len];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; ++i) {
            map.put(inArr[i], i);
        }
        setPost(preArr, 0, len - 1, inArr, 0, len - 1, postArr, len - 1, map);
        return postArr;
    }

    /**
     * 从右往左依次填好后序数组 postArr，postJ 为后序数组 postArr 该填的位置，
     * 返回值为 postArr 该填的下一个位置
     */
    private static int setPost(int[] preArr, int preI, int preJ,
                               int[] inArr, int inI, int inJ,
                               int[] postArr, int postJ,
                               HashMap<Integer, Integer> map) {
        if (preI > preJ) {
            return postJ;
        }
        postArr[postJ--] = preArr[preI];
        int index = map.get(preArr[preI]);
        postJ = setPost(preArr, preJ - inJ + index + 1, preJ, inArr, index + 1, inJ, postArr, postJ, map);
        return setPost(preArr, preI + 1, preI + index - inI, inArr, inI, index - 1, postArr, postJ, map);
    }

}
