package com.siwuxie095.forme.algorithm.chapter3rd.question9th.answer1st;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jiajing Li
 * @date 2019-03-24 21:36:45
 */
public class Print {

    /**
     * 按层打印
     */
    public static void printByLevel(Node head) {
        if (null == head) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        int level = 1;
        Node last = head;
        Node nLast = null;
        queue.offer(head);
        System.out.print("Level " + (level++) + " : ");
        while (!queue.isEmpty()) {
            head = queue.poll();
            System.out.print(head.value + " ");
            if (null != head.left) {
                queue.offer(head.left);
                nLast = head.left;
            }
            if (null != head.right) {
                queue.offer(head.right);
                nLast = head.right;
            }
            if (head == last && !queue.isEmpty()) {
                System.out.print("\nLevel " + (level++) + " : ");
                last = nLast;
            }
        }
        System.out.println();
    }

    /**
     * ZigZag 打印
     */
    public static void printByZigZag(Node head) {
        if (null == head) {
            return;
        }
        Deque<Node> deque = new LinkedList<>();
        int level = 1;
        boolean lr = true;
        Node last = head;
        Node nLast = null;
        deque.offerFirst(head);
        printLevelAndOrientation(level++, lr);
        while (!deque.isEmpty()) {
            if (lr) {
                head = deque.pollFirst();
                if (null != head.left) {
                    nLast = (null == nLast) ? head.left : nLast;
                    deque.offerLast(head.left);
                }
                if (null != head.right) {
                    nLast = (null == nLast) ? head.right : nLast;
                    deque.offerLast(head.right);
                }
            } else {
                head = deque.pollLast();
                if (null != head.right) {
                    nLast = (null == nLast) ? head.right : nLast;
                    deque.offerFirst(head.right);
                }
                if (null != head.left) {
                    nLast = (null == nLast) ? head.left : nLast;
                    deque.offerFirst(head.left);
                }
            }
            System.out.print(head.value + " ");
            if (head == last && !deque.isEmpty()) {
                lr = !lr;
                last = nLast;
                nLast = null;
                System.out.println();
                printLevelAndOrientation(level++, lr);
            }
        }
        System.out.println();
    }

    private static void printLevelAndOrientation(int level, boolean lr) {
        System.out.print("Level " + level + " from ");
        System.out.print(lr ? "left to right: " : "right to left: ");
    }

}
