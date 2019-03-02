package com.siwuxie095.forme.algorithm.chapter2nd.question10th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-02-19 11:30:45
 */
public class Add {

    public static Node addList(Node head1, Node head2) {
        // 第一个链表所代表的值
        int value1 = getValue(head1);
        // 第二个链表所代表的值
        int value2 = getValue(head2);
        // 相加
        int value = value1 + value2;
        /*
         * 将和转成结果链表
         */
        String str = String.valueOf(value);
        char[] charArr = str.toCharArray();
        Node head = new Node(charArr[0] - '0');
        Node curr = head;
        for (int i = 1; i < charArr.length; ++i) {
            Node node = new Node(charArr[i] - '0');
            curr.next = node;
            curr = node;
        }

        return head;
    }

    private static int getValue(Node head) {
        if (null == head) {
            return 0;
        }
        Node curr = head;
        int len = 0;
        while (null != curr) {
            len++;
            curr = curr.next;
        }
        curr = head;
        int value = 0;
        while (null != curr) {
            value = value + curr.value * (int) Math.pow(10, --len);
            curr = curr.next;
        }
        return value;
    }

}
