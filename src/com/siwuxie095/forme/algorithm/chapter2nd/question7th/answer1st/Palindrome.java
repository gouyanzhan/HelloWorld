package com.siwuxie095.forme.algorithm.chapter2nd.question7th.answer1st;

import java.util.Stack;

/**
 * @author Jiajing Li
 * @date 2019-02-18 09:11:11
 */
public class Palindrome {

    /**
     * 判断链表是否是回文结构
     */
    public static boolean isPalindrome(Node head) {
        Stack<Node> stack = new Stack<>();
        Node curr = head;
        // 先将链表元素全部压入栈中
        while (null != curr) {
            stack.push(curr);
            curr = curr.next;
        }
        // 遍历链表，同时弹栈。看元素是否相等，只要有一个不相等，就不是回文结构。
        while (null != head) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

}
