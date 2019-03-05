package com.siwuxie095.forme.algorithm.chapter3rd.question3rd.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-03-05 09:11:09
 */
public class Print {

    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    /**
     * 按照 右-根-左 进行递归遍历
     */
    private static void printInOrder(Node head, int height, String to, int len) {
        if (null == head) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        // middle length
        int lenM = val.length();
        // left length
        int lenL = (len - lenM) / 2;
        // right length
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    private static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; ++i) {
            buf.append(space);
        }
        return buf.toString();
    }

}
