package com.siwuxie095.forme.algorithm.chapter2nd.question12th.answer1st;

import sun.dc.pr.PRError;

import java.util.Stack;

/**
 * @author Jiajing Li
 * @date 2019-02-21 12:43:45
 */
public class Reverse {

    public static Node reverseKNode(Node head, int K) {
        if (K < 2) {
            return head;
        }
        Stack<Node> stack = new Stack<>();
        // 新头节点
        Node newHead = head;
        // 当前节点
        Node currNode = head;
        // 上一组的最后一个节点
        Node prevNode = null;
        // 既起到了遍历的作用，同时也是下一组的第一个节点
        Node nextNode = null;
        while (currNode != null) {
            nextNode = currNode.next;
            stack.push(currNode);
            if (stack.size() == K) {
                prevNode = resign(stack, prevNode, nextNode);
                // 只有第一组时，newHead 才会等于 head，取 currNode，即 第一组的最后一个节点
                newHead = (newHead == head) ? currNode : newHead;
            }
            currNode = nextNode;
        }
        return newHead;
    }


    /**
     * left 即 上一组的最后一个节点，right 即 下一组的第一个节点
     */
    private static Node resign(Stack<Node> stack, Node left, Node right) {
        // 获取栈顶节点为当前节点
        Node currNode = stack.pop();
        /*
         * 上一组的最后一个节点链上当前组的第一个节点
         */
        if (left != null) {
            left.next = currNode;
        }
        /*
         * 当前组的逆序
         */
        Node nextNode = null;
        while (!stack.isEmpty()) {
            nextNode = stack.pop();
            currNode.next = nextNode;
            currNode = nextNode;
        }
        /*
         * 当前组的最后一个节点链上下一组的第一个节点
         */
        currNode.next = right;
        /*
         * 返回当前组的最后一个节点
         */
        return currNode;
    }


}
