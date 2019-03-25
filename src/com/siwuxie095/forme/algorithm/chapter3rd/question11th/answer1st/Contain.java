package com.siwuxie095.forme.algorithm.chapter3rd.question11th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-03-25 18:25:18
 */
public class Contain {

    public static boolean contains(Node t1, Node t2) {
        return check(t1, t2) || contains(t1.left, t2) || contains(t1.right, t2);
    }

    private static boolean check(Node t1, Node t2) {
        if (null == t2) {
            return true;
        }
        if (null == t1 || t1.value != t2.value) {
            return false;
        }
        return check(t1.left, t2.left) && check(t1.right, t2.right);
    }

}
