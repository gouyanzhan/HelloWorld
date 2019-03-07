package com.siwuxie095.forme.algorithm.chapter3rd.question4th.answer2nd;

/**
 * 二叉树的序列化和反序列化
 *
 * 题目：
 * 二叉树被记录成文件的过程叫做二叉树的序列化。通过文件内容重建原来
 * 二叉树的过程叫做二叉树的反序列化。给定一棵二叉树的头节点 head，并
 * 已知二叉树节点值的类型为 32 位整型。请设计一种二叉树序列化和反序列
 * 化方案，并用代码实现。
 *
 * 解答：
 * 方法二：通过层序遍历实现序列化和反序列化。
 * 1、序列化过程：
 * 首先假设序列化的结果字符串为 str，初始时 str = ""。层序遍历二叉树，如果遇到 null 节点，
 * 就在 str 的末尾加上 "#!"，"#" 表示这个节点为空，节点值不存在，"!" 表示一个值的结束；如
 * 果遇到不为空的节点，假设节点值为 3，就在 str 的末尾加上 "3!"。
 * （具体方式是利用队列结构，这也是宽度遍历图的常见方式。）
 *
 * 一棵二叉树如下：
 *                   1
 *              /         \
 *             2           3
 *           /  \       /    \
 *          4   null   null  null
 *        /  \
 *     null  null
 *  它序列化的结果字符串 str 是 1!2!3!4!#!#!#!#!#!
 *
 * 2、反序列化过程：通过结果字符串 str 重构成二叉树。
 * 把结果字符串 str 变成字符串类型的数组，记为 values，数组代表一棵二叉树的层序遍历的节点
 * 顺序。例如：str = "12!3!#!#!#!"，生成的 values 为 ["12", "3", "#", "#", "#"]，
 * 然后用 values[0...4] 按照层序遍历的顺序建立整棵树。
 *
 * 【即 层序遍历序列化，重做层序遍历反序列化】
 *
 * @author Jiajing Li
 * @date 2019-03-06 12:29:32
 */
public class Main {

    public static void main(String[] args) {
        Node head = initTree();
        String levelStr = Serial.serialByLevel(head);
        System.out.println(levelStr);
        head = Serial.reconByLevelString(levelStr);
        System.out.println(head.value + " - " + head.left.value + " - "
                + head.right.value + " - " + head.left.left.value);
    }

    /**
     * 一棵二叉树如下：
     *                   1
     *              /         \
     *             2           3
     *           /  \       /    \
     *          4   null   null  null
     *        /  \
     *     null  null
     */
    private static Node initTree() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;

        return node1;
    }

}
