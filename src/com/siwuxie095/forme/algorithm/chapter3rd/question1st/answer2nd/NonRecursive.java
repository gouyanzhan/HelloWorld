package com.siwuxie095.forme.algorithm.chapter3rd.question1st.answer2nd;

import java.util.Stack;

/**
 * @author Jiajing Li
 * @date 2019-02-25 17:52:01
 */
public class NonRecursive {

    /**
     * 先序遍历：根 - 左 - 右
     */
    public static void preOrderNonRecur(Node head) {
        System.out.println("pre-order:");
        if (null != head) {
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.value + " ");
                if (null != head.right) {
                    stack.push(head.right);
                }
                if (null != head.left) {
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    /**
     * 中序遍历：左 - 根 - 右
     */
    public static void inOrderNonRecur(Node head) {
        System.out.println("in-order:");
        if (null != head) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || null != head) {
                if (null != head) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    /**
     * 后序遍历：左 - 右 - 根（法一）
     */
    public static void postOrderNonRecur1(Node head) {
        System.out.println("post-order:");
        if (null != head) {
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.push(head);
            while (!stack1.isEmpty()) {
                head = stack1.pop();
                stack2.push(head);
                if (null != head.left) {
                    stack1.push(head.left);
                }
                if (null != head.right) {
                    stack1.push(head.right);
                }
            }
            while (!stack2.isEmpty()) {
                System.out.print(stack2.pop().value + " ");
            }
        }
        System.out.println();
    }

    /**
     * 后序遍历：左 - 右 - 根（法二）
     */
    public static void postOrderNonRecur2(Node head) {
        System.out.println("post-order:");
        if (null != head) {
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            Node curr = null;
            while (!stack.isEmpty()) {
                curr = stack.peek();
                if (null != curr.left && head != curr.left && head != curr.right) {
                    stack.push(curr.left);
                } else if (null != curr.right && head != curr.right) {
                    stack.push(curr.right);
                } else {
                    System.out.print(stack.pop().value + " ");
                    head = curr;
                }
            }
        }
        System.out.println();
    }

}
