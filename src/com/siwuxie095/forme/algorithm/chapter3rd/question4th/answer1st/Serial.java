package com.siwuxie095.forme.algorithm.chapter3rd.question4th.answer1st;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jiajing Li
 * @date 2019-03-06 09:20:14
 */
public class Serial {

    /**
     * 序列化
     */
    public static String serialByPre(Node head) {
        if (null == head) {
            return "#!";
        }
        String res = head.value + "!";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
    }

    /**
     * 反序列化
     *
     * recon 即 recognize 的缩写
     */
    public static Node reconByPreString(String preStr) {
        String[] values = preStr.split("!");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i != values.length; ++i) {
            queue.offer(values[i]);
        }
        return reconPreOrder(queue);
    }

    private static Node reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("#")) {
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }

}
