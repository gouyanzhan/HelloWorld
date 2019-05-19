package com.siwuxie095.forme.algorithm.chapter3rd.question2nd.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-03-03 21:57:22
 */
public class Print2 {

    public static void printEdge(Node head) {
        if (null == head) {
            return;
        }
        // 寻找第一个左右孩子不为空的节点，打印过程中的所有节点
        System.out.print(head.value + " ");
        if (null != head.left && null != head.right) {
            printLeftEdge(head.left, true);
            printRightEdge(head.right, true);
        } else {
            printEdge(null != head.left ? head.left : head.right);
        }
        System.out.println();
    }

    private static void printLeftEdge(Node head, boolean print) {
        if (null == head) {
            return;
        }
        // 左右孩子为空，或 print 为 true，就能打印
        if (print || (null == head.left && null == head.right)) {
            System.out.print(head.value + " ");
        }
        printLeftEdge(head.left, print);
        printLeftEdge(head.right, print && null == head.left);
    }

    private static void printRightEdge(Node head, boolean print) {
        if (null == head) {
            return;
        }
        printRightEdge(head.left, print && null == head.right);
        printRightEdge(head.right, print);
        // 左右孩子为空，或 print 为 true，就能打印
        if (print || (null == head.left && null == head.right)) {
            System.out.print(head.value + " ");
        }
    }

}
