package com.siwuxie095.forme.algorithm.chapter2nd.question16th.answer1st;

/**
 * 一种怪异的节点删除方式
 *
 * 题目：
 * 链表节点值类型为 int 型，给定一个链表的节点 node，但不给定整个链表的头节点。如何在链表中删除 node？
 * 请实现这个函数并分析这么会出现哪些问题。
 *
 * 要求时间复杂度为 O(1)。
 *
 * 解答：
 * 本题思路比较简单，举例说明如下：
 * 如：链表 1 -> 2 -> 3 -> null。只知道要删除节点 2，而不知道头节点，那么只需要把节点 2 的值变成节点
 * 3 的值，然后在链表中删除节点 3 即可。
 *
 * 这么做看起来非常简单，但其实有很大的问题。
 *
 * 问题一：
 * 这样的删除方式无法删除最后一个节点。如：如果知道要删除节点 3，而不知道头节点。但它是最后的节点，根本没有
 * 下一个节点来代替节点 3 被删除，那么只有让节点 2 指向 null 这一种办法，而节点 2 又根本找不到，所以根本
 * 没法正确删除节点 3。
 * 那么能不能把节点 3 在内存上的区域变成 null 呢？这样不就相当于让节点 2 的 next 指针指向了 null，起到
 * 节点 3 被删除的效果了吗？答案是不能。null 在系统中是一个特定的区域，如果想让节点 2 的 next 指针指向 null，
 * 必须找到节点 2。
 *
 * 问题二：
 * 这种删除方式在本质上根本就不是删除了 node 节点，而是把 node 节点的值改变，然后删除 node 的下一个节点，
 * 在实际的工程中可能会带来很大问题。比如，工程上的一个节点可能代表很复杂的结构，节点值的复制会相当复杂，或者
 * 改变节点值的操作都是被禁止的；再如，工程上的一个节点代表提供服务的一个服务器，外界对每个节点都有很多依赖，
 * 删除节点 2 时，其实影响了节点 3 对外提供的服务。
 *
 * @author Jiajing Li
 * @date 2019-02-24 18:05:35
 */
public class Main {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        Remove.removeNodeWired(node2);
        System.out.println(node1);
    }

}
