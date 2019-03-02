package com.siwuxie095.forme.algorithm.chapter2nd.question3rd.answer1st;


/**
 * @author Jiajing Li
 * @date 2019-02-16 22:08:04
 */
public class Remove {

    /**
     * 删除链表的中间节点
     */
    public static Node removeMidNode(Node head) {
        // 头节点为空 或 只有一个节点的时候
        if (null == head || null == head.next) {
            return head;
        }
        // 只有两个节点的时候
        if (null == head.next.next) {
            return head.next;
        }
        // 待删除节点的上一个节点
        Node prev = head;
        // 有三个及以上节点的时候，将第三个节点当作当前节点，从它开始进行遍历和判断即可
        Node curr = head.next.next;
        while (null != curr.next && null != curr.next.next) {
            /*
             * 链表长度每增加 2，待删除的节点就后移一个节点，
             * 同样的，待删除节点的上一个节点也后移一个节点
             */
            prev = prev.next;
            curr = curr.next.next;
        }
        prev.next = prev.next.next;
        return head;
    }

    /**
     * 删除链表的 a/b 处节点，即删除比例处的节点
     *
     * （ratio 即 比例）
     */
    public static Node removeByRatio(Node head, int a, int b) {
        // a/b < 0 或 a/b > 1 都不用删除任何节点
        if (a < 1 || a > b) {
            return head;
        }
        // 第一次遍历，计算出链表的长度 n
        int n = 0;
        Node curr = head;
        while (null != curr) {
            n++;
            curr = curr.next;
        }
        // a 除以 b 得到的小数再乘以 n，得到第几个节点
        n = (int) Math.ceil((double) (a * n) / (double) b);
        // n = 1，删除头节点即可
        if (n == 1) {
            head = head.next;
        }
        /*
         * n > 1，删除第 n 个节点，现在就是要找到这第 n 个节点。
         * 方法就是重新做第二次遍历，同时对 n 做减 1，当 n 等于
         * 1 时，当前节点的下一个节点就是第 n 个节点。也就是说当
         * 前节点是待删除节点的上一个节点。
         */
        if (n > 1) {
            curr = head;
            while (--n != 1) {
                curr = curr.next;
            }
            curr.next = curr.next.next;
        }
        return head;
    }

}
