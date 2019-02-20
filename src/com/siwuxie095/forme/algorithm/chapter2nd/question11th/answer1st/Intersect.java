package com.siwuxie095.forme.algorithm.chapter2nd.question11th.answer1st;


import java.util.HashMap;

/**
 * @author Jiajing Li
 * @date 2019-02-20 09:25:14
 */
public class Intersect {

    /**
     * 问题一
     */
    public static Node getLoopNode(Node head) {
        if (null == head || null == head.next || null == head.next.next) {
            return null;
        }
        // 初始化
        Node slow = head.next;
        Node fast = head.next.next;
        /*
         * 第一次相遇时，才跳出循环
         */
        while (slow != fast) {
            // fast 遇到了终点，直接返回 null，说明无环
            if (null == fast.next || null == fast.next.next) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        // fast 指向 head
        fast = head;
        /*
         * 第二次相遇，跳出循环，且相遇处是入环节点
         * （此时，slow 刚好绕环一圈）
         */
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * 问题一（使用哈希表 HashMap 来判断）
     */
    public static Node getLoopNodeByHash(Node head) {
        if (null == head || null == head.next || null == head.next.next) {
            return null;
        }
        Node curr = head;
        HashMap<Node, Node> map = new HashMap<>();
        int count = 0;
        while (curr != null) {
            if (null == curr.next) {
                return null;
            }
            map.put(curr, curr.next);
            count++;
            if (map.size() < count) {
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

    /**
     *
     */
    public static Node noLoop(Node head1, Node head2) {
        if (null == head1 || null == head2) {
            return null;
        }
        Node curr1 = head1;
        Node curr2 = head2;
        int n = 0;
        while (curr1.next != null) {
            n++;
            curr1 = curr1.next;
        }
        while (curr2.next != null) {
            n--;
            curr2 = curr2.next;
        }
        if (curr1 != curr2) {
            return null;
        }
        curr1 = (n > 0) ? head1 : head2;
        curr2 = (curr1 == head1) ? head2 : head1;
        n = Math.abs(n);
        while (n != 0) {
            n--;
            curr1 = curr1.next;
        }
        while (curr1 != curr2) {
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        return curr1;
    }

    /**
     *
     */
    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node curr1 = null;
        Node curr2 = null;
        if (loop1 == loop2) {
            curr1 = head1;
            curr2 = head2;
            int n = 0;
            while (curr1 != loop1) {
                n++;
                curr1 = curr1.next;
            }
            while (curr2 != loop2) {
                n--;
                curr2 = curr2.next;
            }
            curr1 = (n > 0) ? head1 : head2;
            curr2 = (curr1 == head1) ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                curr1 = curr1.next;
            }
            while (curr1 != curr2) {
                curr1 = curr1.next;
                curr2 = curr2.next;
            }
            return curr1;
        } else {
            curr1 = loop1.next;
            while (curr1 != loop1) {
                if (curr1 == loop2) {
                    return loop1;
                }
                curr1 = curr1.next;
            }
            return null;
        }
    }

    /**
     *
     */
    public static Node getIntersectNode(Node head1, Node head2) {
        if (null == head1 || null == head2) {
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (null == loop1 && null == loop2) {
            return noLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }

}
