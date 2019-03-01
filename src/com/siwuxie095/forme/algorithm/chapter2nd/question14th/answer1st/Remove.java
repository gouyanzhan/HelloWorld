package com.siwuxie095.forme.algorithm.chapter2nd.question14th.answer1st;

import java.util.Stack;

/**
 * @author Jiajing Li
 * @date 2019-02-22 21:54:51
 */
public class Remove {

    public static Node removeValue(Node head, int num) {
        Stack<Node> stack = new Stack<>();
        /*
         * 把不等于 num 的全部放到栈中
         */
        while (null != head) {
            if (head.value != num) {
                stack.push(head);
            }
            head = head.next;
        }
        /*
         * 再把栈中的元素重新链起来，相当于删除了链表中所有指定值的节点
         *
         * 注意：第一次进来时，head = null
         */
        while (!stack.isEmpty()) {
            stack.peek().next = head;
            head = stack.pop();
        }
        return head;
    }

}
