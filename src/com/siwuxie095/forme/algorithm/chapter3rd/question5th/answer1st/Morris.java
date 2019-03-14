package com.siwuxie095.forme.algorithm.chapter3rd.question5th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-03-11 22:01:38
 */
public class Morris {

    /**
     * 中序遍历
     */
    public static void morrisIn(Node head) {
        if (null == head) {
            return;
        }
        Node curr1 = head;
        Node curr2 = null;
        while (null != curr1) {
            curr2 = curr1.left;
            if (null != curr2) {
                while (null != curr2.right && curr2.right != curr1) {
                    curr2 = curr2.right;
                }
                if (null == curr2.right) {
                    curr2.right = curr1;
                    curr1 = curr1.left;
                    continue;
                } else {
                    curr2.right = null;
                }
            }
            System.out.print(curr1.value + " ");
            curr1 = curr1.right;
        }
        System.out.println();
    }

    /**
     * 先序遍历
     */
    public static void morrisPre(Node head) {
        if (null == head) {
            return;
        }
        Node curr1 = head;
        Node curr2 = null;
        while (null != curr1) {
            curr2 = curr1.left;
            if (null != curr2) {
                while (null != curr2.right && curr2.right != curr1) {
                    curr2 = curr2.right;
                }
                if (null == curr2.right) {
                    curr2.right = curr1;
                    System.out.print(curr1.value + " ");
                    curr1 = curr1.left;
                    continue;
                } else {
                    curr2.right = null;
                }
            } else {
                System.out.print(curr1.value + " ");
            }
            curr1 = curr1.right;
        }
        System.out.println();
    }

    /**
     * 后序遍历
     */
    public static void morrisPost(Node head) {
        if (null == head) {
            return;
        }
        Node curr1 = head;
        Node curr2 = null;
        while (null != curr1) {
            curr2 = curr1.left;
            if (null != curr2) {
                while (null != curr2.right && curr2.right != curr1) {
                    curr2 = curr2.right;
                }
                if (null == curr2.right) {
                    curr2.right = curr1;
                    curr1 = curr1.left;
                    continue;
                } else {
                    curr2.right = null;
                    printEdge(curr1.left);
                }
            }
            curr1 = curr1.right;
        }
        printEdge(head);
        System.out.println();
    }

    private static void printEdge(Node head) {
        Node tail = reverseEdge(head);
        Node curr = tail;
        while (null != curr) {
            System.out.print(curr.value + " ");
            curr = curr.right;
        }
        reverseEdge(tail);
    }

    private static Node reverseEdge(Node from) {
        Node prevNode = null;
        Node nextNode = null;
        while (null != from) {
            nextNode = from.right;
            from.right = prevNode;
            prevNode = from;
            from = nextNode;
        }
        return prevNode;
    }


}
