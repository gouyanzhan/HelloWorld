package com.siwuxie095.forme.algorithm.chapter2nd.question8th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-02-18 19:06:21
 */
public class Partition {

    public static Node listPartition(Node head, int pivot) {
        if (null == head) {
            return head;
        }
        /*
         * 遍历链表，得到链表长度
         */
        Node curr = head;
        int i = 0;
        while (curr != null) {
            i++;
            curr = curr.next;
        }
        /*
         * 将链表中的节点放到数组中
         */
        Node[] nodeArr = new Node[i];
        curr = head;
        for (i = 0; i != nodeArr.length; i++) {
            nodeArr[i] = curr;
            curr = curr.next;
        }
        /*
         * 对该数组按照规则进行分区
         */
        arrPartition(nodeArr, pivot);
        /*
         * 将节点重新链起来
         */
        for (i = 1; i != nodeArr.length; i++) {
            nodeArr[i - 1].next = nodeArr[i];
        }
        nodeArr[i - 1].next = null;
        // 返回新头节点
        return nodeArr[0];
    }

    private static void arrPartition(Node[] nodeArr, int pivot) {
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while (index != big) {
            if (nodeArr[index].value < pivot) {
                // 注意：传进去的是 small 自增后的值和 index 自增前的值
                swap(nodeArr, ++small, index++);
            } else if (nodeArr[index].value == pivot) {
                index++;
            } else {
                // 同理
                swap(nodeArr, --big, index);
            }
        }
    }

    private static void swap(Node[] nodeArr, int a, int b) {
        Node tmp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = tmp;
    }

}
