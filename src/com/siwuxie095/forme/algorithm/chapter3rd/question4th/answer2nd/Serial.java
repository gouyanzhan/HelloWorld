package com.siwuxie095.forme.algorithm.chapter3rd.question4th.answer2nd;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Jiajing Li
 * @date 2019-03-06 12:29:49
 */
public class Serial {

    /**
     * 序列化
     */
    public static String serialByLevel(Node head) {
        if (null == head) {
            return "#!";
        }
        String res = head.value + "!";
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            if (null != head.left) {
                res += head.left.value + "!";
                queue.offer(head.left);
            } else {
                res += "#!";
            }

            if (null != head.right) {
                res += head.right.value + "!";
                queue.offer(head.right);
            } else {
                res += "#!";
            }
        }
        return res;
    }

    /**
     * 反序列化
     */
    public static Node reconByLevelString(String levelStr) {
        String[] values = levelStr.split("!");
        int index = 0;
        Node head = generateNodeByString(values[index++]);
        Queue<Node> queue = new LinkedList<>();
        if (null != head) {
            queue.offer(head);
        }
        Node node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            node.left = generateNodeByString(values[index++]);
            node.right = generateNodeByString(values[index++]);
            if (null != node.left) {
                queue.offer(node.left);
            }
            if (null != node.right) {
                queue.offer(node.right);
            }
        }
        return head;
    }

    private static Node generateNodeByString(String val) {
        if (val.equals("#")) {
            return null;
        }
        return new Node(Integer.valueOf(val));
    }

}
