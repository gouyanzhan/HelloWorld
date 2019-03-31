package com.siwuxie095.forme.algorithm.chapter3rd.question21th.answer1st;

import java.util.HashMap;

/**
 * @author Jiajing Li
 * @date 2019-03-31 12:13:43
 */
public class ToTree {

    /**
     * 先序数组和中序数组结合重构二叉树
     */
    public static Node preInToTree(int[] preArr, int[] inArr) {
        if (null == preArr || null == inArr) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inArr.length; ++i) {
            map.put(inArr[i], i);
        }
        return preIn(preArr, 0, preArr.length - 1, inArr, 0, inArr.length - 1, map);
    }

    private static Node preIn(int[] preArr, int preI, int preJ, int[] inArr, int inI, int inJ, HashMap<Integer, Integer> map) {
        if (preI > preJ) {
            return null;
        }
        Node head = new Node(preArr[preI]);
        int index = map.get(preArr[preI]);
        head.left = preIn(preArr, preI + 1, preI + index - inI, inArr, inI, index - 1, map);
        head.right = preIn(preArr, preI + index - inI + 1, preJ, inArr, index + 1, inJ, map);
        return head;
    }

    /**
     * 中序数组和后序数组结合重构二叉树
     */
    public static Node inPostToTree(int[] inArr, int[] postArr) {
        if (null == inArr || null == postArr) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inArr.length; ++i) {
            map.put(inArr[i], i);
        }
        return inPost(inArr, 0, inArr.length - 1, postArr, 0, postArr.length - 1, map);
    }

    private static Node inPost(int[] inArr, int inI, int inJ, int[] postArr, int postI, int postJ, HashMap<Integer, Integer> map) {
        if (postI > postJ) {
            return null;
        }
        Node head = new Node(postArr[postJ]);
        int index = map.get(postArr[postJ]);
        head.left = inPost(inArr, inI, index - 1, postArr, postI, postI + index - inI - 1, map);
        head.right = inPost(inArr, index + 1, inJ, postArr, postI + index - inI, postJ - 1, map);
        return head;
    }

    /**
     * 先序数组和后序数组结合重构二叉树
     */
    public static Node prePostToTree(int[] preArr, int[] postArr) {
        if (null == preArr || null == postArr) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < postArr.length; ++i) {
            map.put(postArr[i], i);
        }
        return prePost(preArr, 0 , preArr.length - 1, postArr, 0, postArr.length - 1, map);
    }

    private static Node prePost(int[] preArr, int preI, int preJ, int[] postArr, int postI, int postJ, HashMap<Integer, Integer> map) {
        Node head = new Node(postArr[postJ--]);
        if (preI == preJ) {
            return head;
        }
        int index = map.get(preArr[++preI]);
        head.left = prePost(preArr, preI, preI + index - postI, postArr, postI, index, map);
        head.right = prePost(preArr, preI + index - postI + 1, preJ, postArr, index + 1, postJ, map);
        return head;
    }

}
