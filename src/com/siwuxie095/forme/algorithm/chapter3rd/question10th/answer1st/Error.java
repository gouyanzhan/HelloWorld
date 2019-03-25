package com.siwuxie095.forme.algorithm.chapter3rd.question10th.answer1st;

import java.util.Stack;

/**
 * @author Jiajing Li
 * @date 2019-03-24 23:04:26
 */
public class Error {

    public static Node[] getTwoErrArr(Node head) {
        Node[] errArr = new Node[2];
        if (null == head) {
            return errArr;
        }
        Stack<Node> stack = new Stack<>();
        Node prev = null;
        while (!stack.isEmpty() || null != head) {
            if (null != head) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                if (null != prev && prev.value > head.value) {
                    errArr[0] = (null == errArr[0]) ? prev : errArr[0];
                    errArr[1] = head;
                }
                prev = head;
                head = head.right;
            }
        }
        return errArr;
    }

    private static Node[] getTwoErrParentArr(Node head, Node err1, Node err2) {
        Node[] parentArr = new Node[2];
        if (null == head) {
            return parentArr;
        }
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || null != head) {
            if (null != head) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                if (head.left == err1 || head.right == err1) {
                    parentArr[0] = head;
                }
                if (head.left == err2 || head.right == err2) {
                    parentArr[1] = head;
                }
                head = head.right;
            }
        }
        return parentArr;
    }

    public static Node recoverTree(Node head) {
        Node[] errArr = getTwoErrArr(head);
        Node[] parentArr = getTwoErrParentArr(head, errArr[0], errArr[1]);
        Node err1 = errArr[0];
        Node err1Parent = parentArr[0];
        Node err1Left = err1.left;
        Node err1Right = err1.right;
        Node err2 = errArr[1];
        Node err2Parent = parentArr[1];
        Node err2Left = err2.left;
        Node err2Right = err2.right;
        if (err1 == head) {
                // 情况1
            if (err1 == err2Parent) {
                err1.left = err2Left;
                err1.right = err2Right;
                err2.right = err1;
                err2.left = err1Left;
                // 情况2
            } else if (err2Parent.left == err2) {
                err2Parent.left = err1;
                err2.left = err1Left;
                err2.right = err1Right;
                err1.left = err2Left;
                err1.right = err2Right;
                // 情况3
            } else {
                err2Parent.right = err1;
                err2.left = err1Left;
                err2.right = err1Right;
                err1.left = err2Left;
                err1.right = err2Right;
            }
            head = err2;
        } else if (err2 == head) {
                // 情况4
            if (err2 == err1Parent) {
                err2.left = err1Left;
                err2.right = err1Right;
                err1.left = err2;
                err1.right = err2Right;
                // 情况5
            } else if (err1Parent.left == err1) {
                err1Parent.left = err2;
                err1.left = err2Left;
                err1.right = err2Right;
                err2.left = err1Left;
                err2.right = err1Right;
                // 情况6
            } else {
                err1Parent.right = err2;
                err1.left = err2Left;
                err1.right = err2Right;
                err2.left = err1Left;
                err2.right = err1Right;
            }
            head = err1;
        } else {
            if (err1 == err2Parent) {
                    // 情况7
                if (err1Parent.left == err1) {
                    err1Parent.left = err2;
                    err1.left = err2Left;
                    err1.right = err2Right;
                    err2.left = err1Left;
                    err2.right = err1;
                    // 情况8
                } else {
                    err1Parent.right = err2;
                    err1.left = err2Left;
                    err1.right = err2Right;
                    err2.left = err1Left;
                    err2.right = err1;
                }
            } else if (err2 == err1Parent) {
                    // 情况9
                if (err2Parent.left == err2) {
                    err2Parent.left = err1;
                    err2.left = err1Left;
                    err2.right = err1Right;
                    err1.left = err2;
                    err1.right = err2Right;
                    // 情况10
                } else {
                    err2Parent.right = err1;
                    err2.left = err1Left;
                    err2.right = err1Right;
                    err1.left = err2;
                    err1.right = err2Right;
                }
            } else {
                if (err1Parent.left == err1) {
                        // 情况11
                    if (err2Parent.left == err2) {
                        err1.left = err2Left;
                        err1.right = err2Right;
                        err2.left = err1Left;
                        err2.right = err1Right;
                        err1Parent.left = err2;
                        err2Parent.left = err1;
                        // 情况12
                    } else {
                        err1.left = err2Left;
                        err1.right = err2Right;
                        err2.left = err1Left;
                        err2.right = err1Right;
                        err1Parent.left = err2;
                        err2Parent.right = err1;
                    }
                } else {
                        // 情况13
                    if (err2Parent.left == err2) {
                        err1.left = err2Left;
                        err1.right = err2Right;
                        err2.left = err1Left;
                        err2.right = err1Right;
                        err1Parent.right = err2;
                        err2Parent.left = err1;
                        // 情况14
                    } else {
                        err1.left = err2Left;
                        err1.right = err2Right;
                        err2.left = err1Left;
                        err2.right = err1Right;
                        err1Parent.right = err2;
                        err2Parent.right = err1;
                    }
                }
            }
        }
        return head;
    }

}
