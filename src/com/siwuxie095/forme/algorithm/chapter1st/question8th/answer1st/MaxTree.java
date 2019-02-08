package com.siwuxie095.forme.algorithm.chapter1st.question8th.answer1st;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author Jiajing Li
 * @date 2019-02-08 17:20:15
 */
public class MaxTree {

    public static Node getMaxTree(int[] arr) {
        // 将 int 数组转换成 Node 数组
        Node[] nodeArr = new Node[arr.length];
        for (int i = 0; i != arr.length; ++i) {
            nodeArr[i] = new Node(arr[i]);
        }
        /*
         * 通过栈能更快速的找到每一个数左右两边第一个比它大的数
         * 从栈顶到栈底保持从小到大的顺序
         * 即 栈顶元素始终最小
         */
        Stack<Node> stack = new Stack<>();
        // 当前元素 -> 左边第一个比它大的元素 Map
        HashMap<Node, Node> lBigMap = new HashMap<>();
        // 当前元素 -> 右边第一个比它大的元素 Map
        HashMap<Node, Node> rBigMap = new HashMap<>();
        /*
         * 构造 lBigMap
         */
        for (int i = 0; i != nodeArr.length; ++i) {
            Node currNode = nodeArr[i];
            // 栈不为空，且栈顶元素小于当前元素，则栈顶元素出栈，当前元素入栈
            while (!stack.isEmpty() && stack.peek().value < currNode.value) {
                popStackSetMap(stack, lBigMap);
            }
            stack.push(currNode);
        }
        while (!stack.isEmpty()) {
            popStackSetMap(stack, lBigMap);
        }
        /*
         * 构造 rBigMap
         */
        for (int i = nodeArr.length - 1; i != -1; --i) {
            Node currNode = nodeArr[i];
            while (!stack.isEmpty() && stack.peek().value < currNode.value) {
                popStackSetMap(stack, rBigMap);
            }
            stack.push(currNode);
        }
        while (!stack.isEmpty()) {
            popStackSetMap(stack, rBigMap);
        }
        /*
         * 构造每一棵子树的头节点（相当于构造出了整棵 MaxTree）
         */
        Node head = null;
        for (int i = 0; i != nodeArr.length; ++i) {
            Node currNode = nodeArr[i];
            // 左边第一个比当前节点大的节点
            Node left = lBigMap.get(currNode);
            // 右边第一个比当前节点大的节点
            Node right = rBigMap.get(currNode);
            if (null == left && null == right) {
                head = currNode;
            } else if (null == left) {
                if (null == right.left) {
                    right.left = currNode;
                } else {
                    right.right = currNode;
                }
            } else if (null == right) {
                if (null == left.left) {
                    left.left = currNode;
                } else {
                    left.right = currNode;
                }
            } else {
                Node parent = left.value < right.value ? left : right;
                if (null == parent.left) {
                    parent.left = currNode;
                } else {
                    parent.right = currNode;
                }
            }
        }
        return head;
    }

    private static void popStackSetMap(Stack<Node> stack, HashMap<Node, Node> map) {
        Node popNode = stack.pop();
        if (stack.isEmpty()) {
            map.put(popNode, null);
        } else {
            map.put(popNode, stack.peek());
        }
    }

}
