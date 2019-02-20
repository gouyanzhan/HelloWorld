package com.siwuxie095.forme.algorithm.chapter2nd.question11th.answer1st;

/**
 * 两个单链表相交的一系列问题
 *
 * 题目：
 * 在本题中，单链表可能有环，也可能无环。给定两个单链表的头节点 head1 和 head2，
 * 这两个链表可能相交，也可能不相交。请实现一个函数，如果两个链表相交，请返回相交
 * 的第一个节点；如果不相交，返回 null 即可。
 * 要求：如果链表 1 的长度为 N，链表 2 的长度为 M，时间复杂度请达到 O(N + M)，
 * 额外空间复杂度请达到 O(1)。
 *
 * 解答：
 * 这道题需要分析的情况非常多，同时因为有额外空间复杂度为 O(1) 的限制，所以实现
 * 起来也比较困难。
 * 本题可以拆分成三个子问题，每个问题都可以作为一道独立的算法题，具体如下：
 * 问题一：如何判断一个链表是否有环，如果有则返回第一个进入环的节点，没有则返回 null。
 * 问题二：如何判断两个无环链表是否相交，相交则返回第一个相交节点，不相交则返回 null。
 * 问题三：如何判断两个有环链表是否相交，相交则返回第一个相交节点，不相交则返回 null。
 * （注意：如果一个链表有环，另外一个链表无环，它们是不可能相交的，直接返回 null。）
 *
 * 下面逐一分析每个问题：
 * 1、对于问题一：
 * 如果一个链表没有环，那么遍历链表一定可以到达链表的终点；如果链表有环，那么遍历链表
 * 就永远在环里转下去了。如何找到第一个入环节点，具体过程如下：
 * （1）设置一个慢指针 slow 和一个快指针 fast。在开始时，slow 和 fast 都指向链表
 * 的头节点 head。然后 slow 每次移动一步，fast 每次移动两步，在链表中遍历起来。
 * （2）如果链表无环，那么 fast 在移动过程中，一定会先遇到终点，一旦 fast 到终点，
 * 说明链表是无环的，直接返回 null，表示该链表无环，当然也没有第一个入环的节点。
 * （3）如果链表有环，那么 fast 和 slow 一定会在环中的某个位置相遇，当 fast 和 slow
 * 第一次相遇时，将 fast 指针重新指向 head，slow 不动。接下来，fast 指针从每次移
 * 动两步改为每次移动一步，slow 指针依然每次移动一步，然后继续遍历。
 * （4）fast 和 slow 一定会再次相遇，也就是第二次相遇，并且是在第一个入环的节点处
 * 相遇。（注意：也可以用哈希表 HashMap 完成问题一的判断，但不符合题目关于空间复杂
 * 度的要求。）
 *
 * 解决了问题一，就知道两个是否有环，如果一个有环，一个无环，则不可能相交。能相交的
 * 就两种情况，即 问题二和问题三。
 *
 * 2、对于问题二：
 * 如果两个无环链表相交，那么从相交节点开始，一直到两个链表终止的这一段，是两个链表
 * 共享的。具体过程如下：
 * （1）链表 1 从头节点开始，走到最后一个节点，统计链表 1 的长度，记为 len1，同时
 * 记录链表 1 的最后一个节点，记为 end1。
 * （2）链表 2 从头节点开始，走到最后一个节点，统计链表 2 的长度，记为 len2，同时
 * 记录链表 2 的最后一个节点，记为 end2。
 * （3）如果 end1 != end2，说明两个链表不相交，返回 null 即可；如果 end1 == end2，
 * 说明两个链表相交，进入步骤 （4） 来找寻第一个相交节点。
 * （4）如果链表 1 比较长，链表 1 就先走 len1 - len2 步；反之，链表 2 就先走 len1
 * - len2 步。然后两个链表一起走，一起走的过程中，两个链表第一次走到一起的那个节点，就
 * 是第一个相交的节点。
 *
 * 3、对于问题三：
 * 考虑问题三的时候，已经得到了两个链表各自的第一个入环节点，假设链表 1 的第一个入环节点记为 loop1，
 * 链表 2 的第一个入环节点记为 loop2。具体过程如下：
 * （1）如果 loop1 == loop2，只需要考虑链表 1 从头开始到 loop1 这一段，与链表 2 从头开始到 loop2
 * 这一段，在哪里第一次相交即可，而不用考虑进环该怎么处理，即 转化成了问题二。只不过问题二是把 null
 * 作为一个链表的终点，这里是把 loop1 或 loop2 作为链表的终点，但是判断的主要过程是一样的。
 * （2）如果 loop1 != loop2，让链表 1 从 loop1 出发，因为 loop1 和之后的所有节点都在环上，所以
 * 将来一定能回到 loop1。如果回到 loop1 之前并没有遇到 loop2，说明两个链表不相交，直接返回 null；
 * 如果回到 loop1 之前遇到了 loop2，说明两个链表相交。因为 loop1 和 loop2 都在两条链表上，只不过
 * loop1 离链表 1 更近，loop2 离链表 2 更近，所以此时返回 loop1 或 loop2 均可。
 *
 * 4、对于整个问题：
 * 结合问题一、问题二、问题三的解法即可解决。
 *
 * @author Jiajing Li
 * @date 2019-02-20 09:24:21
 */
public class Main {

    public static void main(String[] args) {
        // 问题一
        testGetLoopNode();
        System.out.println("------");
        // 问题二
        testNoLoop();
        System.out.println("------");
        // 问题三
        testBothLoop();
        System.out.println("------");
        // 整个问题
        testGetIntersectNode();
        System.out.println("------");
    }

    private static void testGetLoopNode() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        Node loop = Intersect.getLoopNode(node1);
        System.out.println(loop.value);
        loop = Intersect.getLoopNodeByHash(node1);
        System.out.println(loop.value);
    }

    private static void testNoLoop() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node5.next = node6;
        node6.next = node3;

        Node intersectNode = Intersect.noLoop(node1, node5);
        System.out.println(intersectNode.value);
    }

    private static void testBothLoop() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node5.next = node6;
        node6.next = node2;
        
        Node loop1 = Intersect.getLoopNode(node1);
        Node loop5 = Intersect.getLoopNode(node5);
        Node intersectNode = Intersect.bothLoop(node1, loop1, node5, loop5);
        System.out.println(intersectNode.value);
    }

    private static void testGetIntersectNode() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node5.next = node6;
        node6.next = node2;

        Node intersectNode = Intersect.getIntersectNode(node1, node5);
        System.out.println(intersectNode.value);
    }

}
