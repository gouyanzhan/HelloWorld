package com.siwuxie095.forme.algorithm.chapter2nd.question7th.answer2nd;

import java.util.Stack;

/**
 * @author Jiajing Li
 * @date 2019-02-18 09:31:08
 */
public class Palindrome {

    public static boolean isPalindrome(Node head) {
        // 头节点为空 或 只有一个节点，直接返回 true
        if (null == head || null == head.next) {
            return true;
        }
        // 链表的右半部分的第一个节点（典型的：当只有两个节点时；当只有三个节点时；）
        Node right = head.next;
        Node curr = head;
        /*
         * 至少判断到链表存在三个节点。
         *
         * right 移动速度是 curr 移动速度的一半，当 curr 移动到链表末尾时，right 刚好在中间。
         */
        while (curr.next != null && curr.next.next != null) {
            right = right.next;
            curr = curr.next.next;
        }
        Stack<Node> stack = new Stack<>();
        // 将链表的右半部分压栈
        while (right != null) {
            stack.push(right);
            right = right.next;
        }
        // 从栈顶到栈底遍历该栈，也就是弹栈。看元素是否相等，只要有一个不相等，就不是回文结构。
        while (!stack.isEmpty()) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

}
