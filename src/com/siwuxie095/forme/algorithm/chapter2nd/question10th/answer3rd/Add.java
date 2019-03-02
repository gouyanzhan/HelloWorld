package com.siwuxie095.forme.algorithm.chapter2nd.question10th.answer3rd;

/**
 * @author Jiajing Li
 * @date 2019-02-19 11:30:45
 */
public class Add {

    public static Node addList(Node head1, Node head2) {
        // 逆序两个链表
        head1 = reverseList(head1);
        head2 = reverseList(head2);
        // 进位 carry
        int ca = 0;
        // 第一个链表中节点的值
        int n1 = 0;
        // 第二个链表中节点的值
        int n2 = 0;
        // n1 + n2 + ca 后的值
        int n = 0;
        // 两个链表的当前节点
        Node curr1 = head1;
        Node curr2 = head2;
        // 新生成的节点（始终代表最终结果的最高位）
        Node newNode = null;
        // 之前生成的节点
        Node prevNode = null;
        // 开始生成新链表
        while (null != curr1 || null != curr2) {
            n1 = (null != curr1) ? curr1.value : 0;
            n2 = (null != curr2) ? curr2.value : 0;
            n = n1 + n2 + ca;
            prevNode = newNode;
            newNode = new Node(n % 10);
            newNode.next = prevNode;
            ca = n / 10;
            curr1 = (null != curr1) ? curr1.next : null;
            curr2 = (null != curr2) ? curr2.next : null;
        }
        // 边界条件处理
        if (ca == 1) {
            prevNode = newNode;
            newNode = new Node(1);
            newNode.next = prevNode;
        }
        // 再将两个链表逆序回去
        reverseList(head1);
        reverseList(head2);
        // 新生成的链表所代表的数，从左到右是从高位到低位的顺序
        return newNode;
    }

    /**
     * 逆序一个链表
     */
    private static Node reverseList(Node head) {
        Node prevNode = null;
        Node nextNode = null;
        while (null != head) {
            nextNode = head.next;
            head.next = prevNode;
            prevNode = head;
            head = nextNode;
        }
        return prevNode;
    }

}
