package com.siwuxie095.forme.algorithm.chapter2nd.question9th.answer2nd;

/**
 * 复制含有随机指针节点的链表
 *
 * 题目：
 * 有这样一种特殊的链表节点类：Node 类中的 value 是节点值，next 指针和正常单链表中 next
 * 指针的意义一样，都指向下一个节点，rand 指针是 Node 类中新增的指针，这个指针可能指向链表
 * 中的任意一个节点，也可能指向 null。
 * 给定一个由 Node 节点类型组成的无环单链表的头节点 head（注意：无环是相对于 next 指针而言），
 * 请实现一个函数完成这个链表中所有结构的复制，并返回复制的新链表的头节点。
 * 如：
 * 链表： 1 -> 2 -> 3 -> null，假设 1 的 rand 指针指向 3；2 的 rand 指针指向 null；3 的
 * rand 指针指向 1。复制后的链表应该也是这种结构，比如：1^ -> 2^ -> 3^ -> null。1^ 的 rand
 * 指针指向 3^；2^ 的 rand 指针指向 null；3^ 的 rand 指针指向 1^。最后返回 1^。
 *
 * 进阶：不使用额外的数据结构，只用有限几个变量，且在时间复杂度为 O(N) 内完成原问题要实现的函数。
 *
 * 解答：
 * 进阶解法：进阶解法不使用哈希表来保存对应关系，而只用有限的几个变量完成所有的功能。具体过程如下：
 * 1、首先从左到右遍历链表，对每个节点 currNode 都复制生成相应的副本节点 copyNode，然后把 copyNode
 * 放在 currNode 和下一个要遍历节点的中间。
 * 如：
 * 还是链表 1 -> 2 -> 3 -> null，此步完成后，变成 1 -> 1^ -> 2 -> 2^ -> 3 -> 3^ -> null。
 * 2、再此从左到右遍历链表，在遍历时，设置每一个副本节点的 rand 指针。因为每个节点的副本节点都在自己的后
 * 一个，所以对于 1 -> 1^ -> 2 -> 2^ -> 3 -> 3^ -> null，要想找到 1^ 的 rand 指针指向的节点，就
 * 要找到 1 的rand 指针指向的节点的下一个节点。
 * 3、步骤 2 完成后，节点 1、2、3 之间的 rand 关系没有变化，节点 1^、2^、3^ 之间的 rand 关系也被正确
 * 设置了。此时所有节点与副本节点串在一起，将其分离出来即可。
 * 4、将 1^ 作为结果返回即可。
 *
 * （主要还是考察了利用有限几个变量完成链表调整的代码实现能力）
 *
 * @author Jiajing Li
 * @date 2019-02-19 10:22:16
 */
public class Main {

    public static void main(String[] args) {
        Node head = initNode();
        Node newHead = Rand.copyListWithRand(head);
        int count = 0;
        while (newHead != null) {
            Integer currValue = newHead.value;
            Integer nextValue = (null == newHead.next) ? null : newHead.next.value;
            Integer randValue = (null == newHead.rand) ? null : newHead.rand.value;
            System.out.println("第 " + (++count) + " 个节点的 value = " + currValue + "，next 指向的节点的 value = " + nextValue + "，rand 指向的节点的 value = " + randValue);
            newHead = newHead.next;
        }
    }

    private static Node initNode() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        node1.rand = node3;
        node2.rand = null;
        node3.rand = node1;

        return node1;
    }

}
