package com.siwuxie095.forme.algorithm.chapter3rd.question4th.answer1st;

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
 * 方法一：通过先序遍历实现序列化和反序列化。
 * 1、序列化过程：
 * 首先假设序列化的结果字符串为 str，初始时 str = ""。先序遍历二叉树，如果遇到 null 节点，
 * 就在 str 的末尾加上 "#!"，"#" 表示这个节点为空，节点值不存在，"!" 表示一个值的结束；如
 * 果遇到不为空的节点，假设节点值为 3，就在 str 的末尾加上 "3!"。
 *
 * 一棵二叉树如下：
 *           12
 *         /    \
 *       3      null
 *    /   \
 *  null  null
 *  它序列化的结果字符串 str 是 12!3!#!#!#!
 *  为什么要在每一个节点值的后面加上 "!" 呢？这是因为如果不标记一个值的结束，最后产生的结果
 *  会有歧义。
 *
 *  另一个二叉树如下：
 *            1
 *         /    \
 *       23     null
 *     /   \
 *  null  null
 * 它序列化的结果字符串 str 是 1!23!#!#!#!
 * 如果不在一个值结束时加入特殊字符，那么这两个二叉树序列化的结果都是 123###，生成的字符串
 * 并不代表唯一的树。
 *
 * 2、反序列化过程：通过结果字符串 str 重构成二叉树。
 * 把结果字符串 str 变成字符串类型的数组，记为 values，数组代表一棵二叉树的先序遍历的节点
 * 顺序。例如：str = "12!3!#!#!#!"，生成的 values 为 ["12", "3", "#", "#", "#"]，
 * 然后用 values[0...4] 按照先序遍历的顺序建立整棵树。
 *
 * 【即 先序遍历序列化，重做先序遍历反序列化】
 *
 * @author Jiajing Li
 * @date 2019-03-06 09:19:45
 */
public class Main {

    public static void main(String[] args) {
        Node head = initTree();
        String preStr = Serial.serialByPre(head);
        System.out.println(preStr);
        head = Serial.reconByPreString(preStr);
        System.out.println(head.value + " - " + head.left.value);
    }

    /**
     * 一棵二叉树如下：
     *           12
     *         /    \
     *       3      null
     *    /   \
     *  null  null
     */
    private static Node initTree() {
        Node node1 = new Node(12);
        Node node2 = new Node(3);

        node1.left = node2;

        return node1;
    }

}
