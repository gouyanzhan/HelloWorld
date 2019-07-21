package com.siwuxie095.forme.algorithm.chapter9th.question24th.answer1st;

import java.util.Comparator;

/**
 * @author Jiajing Li
 * @date 2019-07-20 21:41:14
 */
public class MyHeap<K> {

    /**
     * 堆头节点
     */
    private Node<K> head;

    /**
     * 堆尾节点
     */
    private Node<K> last;

    /**
     * 当前堆的大小
     */
    private long size;

    /**
     * 大根堆或小根堆
     */
    private Comparator<K> comp;

    public MyHeap(Comparator<K> comp) {
        this.head = null;
        this.last = null;
        this.size = 0;
        // 基于比较器决定是大根堆还是小根堆
        this.comp = comp;
    }

    public K getHead() {
        return null == head ? null : head.value;
    }

    public long getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 添加一个新节点到堆中
     */
    public void add(K value) {
        Node<K> newNode = new Node<>(value);
        if (size == 0) {
            head = newNode;
            last = newNode;
            size++;
            return;
        }
        Node<K> node = last;
        Node<K> parent = node.parent;
        // 找到正确的位置并插入到新节点
        while (null != parent && node != parent.left) {
            node = parent;
            parent = node.parent;
        }
        Node<K> nodeToAdd = null;
        if (null == parent) {
            nodeToAdd = mostLeft(head);
            nodeToAdd.left = newNode;
            newNode.parent = nodeToAdd;
        } else if (null == parent.right) {
            parent.right = newNode;
            newNode.parent = parent;
        } else {
            nodeToAdd = mostLeft(parent.right);
            nodeToAdd.left = newNode;
            newNode.parent = nodeToAdd;
        }
        last = newNode;
        // 建堆及其调整
        heapInsertModify();
        size++;
    }

    public K popHead() {
        if (size == 0) {
            return null;
        }
        Node<K> res = head;
        if (size == 1) {
            head = null;
            last = null;
            size--;
            return res.value;
        }
        Node<K> oldLast = popLastAndSetPreviousLast();
        // 如果弹出堆尾节点后，堆的大小等于 1 的处理
        if (size == 1) {
            head = oldLast;
            last = oldLast;
            return res.value;
        }
        // 如果弹出的堆尾节点后，堆的大小大于 1 的处理
        Node<K> headLeft = res.left;
        Node<K> headRight = res.right;
        oldLast.left = headLeft;
        if (null != headLeft) {
            headLeft.parent = oldLast;
        }
        oldLast.right = headRight;
        if (null != headRight) {
            headRight.parent = oldLast;
        }
        res.left = null;
        res.right = null;
        head = oldLast;
        // 堆 heapify 过程
        heapify(oldLast);
        return res.value;
    }

    /**
     * 找到以 node 为头的子树中，最左的节点
     */
    private Node<K> mostLeft(Node<K> node) {
        while (null != node.left) {
            node = node.left;
        }
        return node;
    }

    /**
     * 找到以 node 为头的子树中，最右的节点
     */
    private Node<K> mostRight(Node<K> node) {
        while (null != node.right) {
            node = node.right;
        }
        return node;
    }

    /**
     * 建堆及调整的过程
     */
    private void heapInsertModify() {
        Node<K> node = last;
        Node<K> parent = node.parent;
        if (null != parent && comp.compare(node.value, parent.value) < 0) {
            last = parent;
        }
        while (null != parent && comp.compare(node.value, parent.value) < 0) {
            swapClosedTwoNodes(node, parent);
            parent = node.parent;
        }
        if (null != head.parent) {
            head = head.parent;
        }
    }

    /**
     * 堆 heapify 过程
     */
    private void heapify(Node<K> node) {
        Node<K> left = node.left;
        Node<K> right = node.right;
        Node<K> most = node;
        while (null != left) {
            if (null != left && comp.compare(left.value, most.value) < 0) {
                most = left;
            }
            if (null != right && comp.compare(right.value, most.value) < 0) {
                most = right;
            }
            if (most != node) {
                swapClosedTwoNodes(most, node);
            } else {
                break;
            }
            left = node.left;
            right = node.right;
            most = node;
        }
        if (node.parent == last) {
            last = node;
        }
        while (null != node.parent) {
            node = node.parent;
        }
        head = node;
     }

    /**
     * 交换相邻的两个节点
     */
    private void swapClosedTwoNodes(Node<K> node, Node<K> parent) {
        if (null == node || null == parent) {
            return;
        }
        Node<K> parentParent = parent.parent;
        Node<K> parentLeft = parent.left;
        Node<K> parentRight = parent.right;
        Node<K> nodeLeft = node.left;
        Node<K> nodeRight = node.right;
        node.parent = parentParent;
        if (null != parentParent) {
            if (parent == parentParent.left) {
                parentParent.left = node;
            } else {
                parentParent.right = node;
            }
        }
        parent.parent = node;
        if (null != nodeLeft) {
            nodeLeft.parent = parent;
        }
        if (null != nodeRight) {
            nodeRight.parent = parent;
        }
        if (node == parent.left) {
            node.left = parent;
            node.right = parentRight;
            if (null != parentRight) {
                parentRight.parent = node;
            }
        } else {
            node.left = parentLeft;
            node.right = parent;
            if (null != parentRight) {
                parentLeft.parent = node;
            }
        }
        parent.left = nodeLeft;
        parent.right = nodeRight;
    }

    /**
     * 在树中弹出堆尾节点后，找到原来的倒数第二个节点设置成新的队尾节点
     */
    private Node<K> popLastAndSetPreviousLast() {
        Node<K> node = last;
        Node<K> parent = node.parent;
        while (null != parent && node != parent.right) {
            node = parent;
            parent = node.parent;
        }
        if (null == parent) {
            node = last;
            parent = node.parent;
            node.parent = null;
            if (node == parent.left) {
                parent.left = null;
            } else {
                parent.right = null;
            }
            last = mostRight(head);
        } else {
            Node<K> newLast = mostRight(parent.left);
            node = last;
            parent = node.parent;
            node.parent = null;
            if (node == parent.left) {
                parent.left = null;
            } else {
                parent.right = null;
            }
            last = newLast;
        }
        size--;
        return node;
    }

}
