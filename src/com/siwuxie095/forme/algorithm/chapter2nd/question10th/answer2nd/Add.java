package com.siwuxie095.forme.algorithm.chapter2nd.question10th.answer2nd;

import java.util.Stack;

/**
 * @author Jiajing Li
 * @date 2019-02-19 11:30:45
 */
public class Add {

    public static Node addList(Node head1, Node head2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while (null != head1) {
            s1.push(head1.value);
            head1 = head1.next;
        }
        while (null != head2) {
            s2.push(head2.value);
            head2 = head2.next;
        }
        // 进位 carry
        int ca = 0;
        // s1 中弹出来的值
        int n1 = 0;
        // s2 中弹出来的值
        int n2 = 0;
        // n1 + n2 + ca 后的值
        int n = 0;

        // 新生成的节点（始终代表最终结果的最高位）
        Node newNode = null;
        // 之前生成的节点
        Node prevNode = null;
        // 开始生成新链表
        while (!s1.isEmpty() || !s2.isEmpty()) {
            n1 = s1.isEmpty() ? 0 : s1.pop();
            n2 = s2.isEmpty() ? 0 : s2.pop();
            n = n1 + n2 + ca;
            prevNode = newNode;
            newNode = new Node(n % 10);
            newNode.next = prevNode;
            ca = n / 10;
        }
        // 边界条件处理
        if (ca == 1) {
            prevNode = newNode;
            newNode = new Node(1);
            newNode.next = prevNode;
        }
        // 新生成的链表所代表的数，从左到右是从高位到低位的顺序
        return newNode;
    }

}
