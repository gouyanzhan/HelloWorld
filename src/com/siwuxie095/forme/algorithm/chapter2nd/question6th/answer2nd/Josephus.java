package com.siwuxie095.forme.algorithm.chapter2nd.question6th.answer2nd;

/**
 * @author Jiajing Li
 * @date 2019-02-17 21:31:28
 */
public class Josephus {

    public static Node josephusKill(Node head, int m) {
        // 头节点为空 或 只有一个节点 或 报数小于 1
        if (null == head || head.next == head || m < 1) {
            return head;
        }
        // 遍历，计算环中节点个数 tmp，也就是编号
        Node curr = head.next;
        int tmp = 1;
        while (curr != head) {
            tmp++;
            curr = curr.next;
        }
        // 计算出生存下来的编号
        tmp = getLive(tmp, m);
        // 遍历，找到该编号的节点
        while (--tmp != 0) {
            head = head.next;
        }
        // 自循环（自己链自己，从原来的环上脱落下来）
        head.next = head;
        return head;
    }

    public static int getLive(int i, int m) {
        if (i == 1) {
            return 1;
        }
        return (getLive(i - 1, m) + m - 1) % i + 1;
    }

}
