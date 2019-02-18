package com.siwuxie095.forme.algorithm.chapter2nd.question7th.answer3rd;

/**
 * @author Jiajing Li
 * @date 2019-02-18 09:58:05
 */
public class Palindrome {

    public static boolean isPalindrome(Node head) {
        if (null == head || null == head.next) {
            return true;
        }
        /*
         * 找到中间节点
         */
        // n1 用于找中间节点
        Node n1 = head;
        // n2 用于遍历
        Node n2 = head;
        // n2 移动速度是 n1 的两倍，所以 n2 到结尾时，n1 刚好到中部。
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }
        // 拿到右半区第一个节点
        n2 = n1.next;
        // 从中间节点与右半区断开，相当于 mid.next -> null
        n1.next = null;
        /*
         * 右半区反转
         */
        Node n3 = null;
        while (n2 != null) {
            // 保存下一个节点
            n3 = n2.next;
            // 反转
            n2.next = n1;
            // n1 移动
            n1 = n2;
            // n2 移动
            n2 = n3;
        }
        /*
         * 进行回文比较
         */
        // 保存最后一个节点
        n3 = n1;
        // n2 赋值
        n2 = head;
        boolean res = true;
        // n1 是右边第一个节点，n2 是左边第一个节点
        while (n1 != null && n2 != null) {
            if (n1.value != n2.value) {
                res = false;
                break;
            }
            // 从右到中
            n1 = n1.next;
            // 从左到中
            n2 = n2.next;
        }
        /*
         * 恢复链表
         */
        // n1 变成了最后一个节点的前一个节点
        n1 = n3.next;
        // 最后一个节点先断开
        n3.next = null;
        while (n1 != null) {
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }

        return res;
    }

}
