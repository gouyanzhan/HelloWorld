package com.siwuxie095.forme.algorithm.chapter3rd.question1st.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-02-25 17:42:35
 */
public class Recursive {

    /**
     * 先序遍历：根 - 左 - 右
     */
    public static void preOrderRecur(Node head) {
        if (null == head) {
            return;
        }
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    /**
     * 中序遍历：左 - 根 - 右
     */
    public static void inOrderRecur(Node head) {
        if (null == head) {
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

    /**
     * 后序遍历：左 - 右 - 根
     */
    public static void postOrderRecur(Node head) {
        if (null == head) {
            return;
        }
        postOrderRecur(head.left);
        postOrderRecur(head.right);
        System.out.print(head.value + " ");
    }

}
