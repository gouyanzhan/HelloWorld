package com.siwuxie095.forme.algorithm.chapter9th.question24th.answer1st;

import java.util.Comparator;

/**
 * 设计一个没有扩容负担的堆结构
 *
 * 题目：
 * 堆结构一般是使用固定长度的数组结构来实现的。这样的实现虽然足够经典，但存在扩容的负担，比如不断向堆中
 * 增加元素，使得固定数组快耗尽时，就不得不申请一个更大的固定数组，然后把原来数组中的对象复制到新的数组
 * 里完成堆的扩容，所以，如果扩容时堆中的元素个数为 N，那么扩容行为的时间复杂度为 O(N)。请设计一种没有
 * 扩容负担的堆结构，即在任何时刻有关堆的操作时间复杂度都不超过 O(logN)。
 *
 * 要求：
 * 1、没有扩容的负担。
 * 2、可以生成小根堆，也可以生成大根堆。
 * 3、包含 getHead 方法，返回当前堆顶的值。
 * 4、包含 getSize 方法，返回当前堆的大小。
 * 5、包含 add(x) 方法，即向堆中新加元素 x，操作后依然是小根堆/大根堆。
 * 6、包含 popHead 方法，即删除并返回堆顶的值，操作后依然是小根堆/大根堆。
 * 7、如果堆中的节点个数为 N，那么各个方法的时间复杂度为:
 * getHead: O(1)
 * getSize: O(1)
 * add: O(logN)
 * popHead: O(logN)
 *
 * 解答：
 * 本题的设计方法有很多，这里提供的方法实际上是实现了完全二叉树结构，并含有堆的调整过程。二叉树的节点类
 * 型如下，比经典的二叉树节点多一条指向父节点的 parent 指针。
 * 这里实现的堆结构叫 MyHeap 类，MyHeap 中有四个重要的组成部分。
 * （1）head：Node 类型的变量，表示当前堆的头节点。
 * （2）last：Node 类型的变量，表示当前堆的堆尾节点，也就是最后一排的最右节点。
 * （3）size：整型变量，表示当前堆的大小。
 * （4）comp：继承了 Comparator 接口的比较器类型的变量。在构造 MyHeap 实例时由用户定义，通过定义堆
 * 中元素的比较方式，自然可以将堆实现大根堆或小根堆。comp 变量是在构造时一经设定就不能更改。
 * 所有堆的操作在执行时，变量 head、last 和 size 都能够正确更新是 MyHeap 类实现的重点。其中 getHead
 * 方法和 getSize 方法是很容易实现的，就是直接取值返回即可。那么接下来就重点介绍 add 方法和 popHead
 * 方法的实现细节。
 *
 * add 方法的实现。如果想要把元素 value 加入到堆中，首先生成二叉树节点类型的实例，即 new Node<value
 * 的类型>(value)，假设生成的节点为 newNode。把 newNode 加到二叉树上的具体过程如下：
 * 1、如果 size == 0，说明当前的堆没有节点，三个变量简单赋值即可：
 * if (size == 0) {
 *     head = newNode;
 *     last = newNode;
 *     size++;
 *     return;
 * }
 * 2、如果 size > 0，说明当前的堆有节点，此时想要加上 newNode 的困难在于，不知道 newNode 应该加到
 * 二叉树的什么位置。此时利用 last 的位置来找到 newNode 应该加的位置。
 * 1）last 具体在堆中的什么位置特别关键，具体有如下三种情况：
 * 情况一，last 是当前层的最后一个节点，也就是当前层已经满，无法在加新的节点，那么 newNode 应该加在
 * 新一层最左的位置。
 * 情况二，如果 last 是 last 父节点的左孩子，那么 newNode 应该加在 last 父节点的右孩子的位置。
 * 情况三，如果 last 既不是情况一，也不是情况二，也就是当前层并没有添加满，但是 last 的父节点已经添加
 * 满，此时需要一个向上寻找的过程。先以 last 作为当前节点，然后看看当前节点是不是当前节点的父节点的左孩
 * 子，如果不是，就一直向上。直到当前节点是当前节点的父节点的左孩子，那么 newNode 应该加在当前节点的父
 * 节点的右子树的最左节点的左孩子的位置。
 * 2）加完 newNode 之后，newNode 就成为新的 last，令 last = newNode，同时 size++。
 * 3）此时的 last 节点就是新加节点，虽然加在了二叉树上，但还没有经历建堆的调整过程。比如，如果整个堆是
 * 大根堆，而新加节点的值又很大，按道理，这个节点应该经历向上交换的过程，所以最后应该从 last 节点向上经
 * 历堆的调整过程，即 heapInsert 过程。同时需要特别注意的是，在交换的过程中，last 和 head 的值可能会
 * 变化。只有 head 和 last 在调整的每一步都正确更新，整个设计才能不出错。具体代码请参看 MyHeap 类的
 * heapInsertModify 方法。
 *
 * popHead 方法的实现。删除堆顶节点并返回堆顶的值，具体过程如下：
 * 1、如果 size == 0，说明当前堆为空，直接返回 null，也不需要任何调整。
 * 2、如果 size == 1，说明当前堆里只有一个节点，返回节点值并将堆清空，即如下代码：
 * Node<K> res = head;
 * if (size == 1) {
 *     head = null;
 *     last == null;
 *     size--;
 *     return res.value;
 * }
 * 3、如果 size > 1，把当前堆顶节点记为 res，把最后一个元素（last）放在堆顶位置作为新的头，同时从头部
 * 开始进行堆的调整，使其继续是大根堆/小根堆，最后返回 res.value 即可。
 * 话虽如此，但是这个过程还是要保证 head 和 last 的正确更新，具体细节如下：
 * 1）先把堆中最后一个节点（last）和整个堆结构断开，记为 oldLast。因为 oldLast 要放在头节点的位置，所
 * 以 last 的值应该变成 oldLast 节点之前的那个节点，同样有三种情况。
 * 情况一，如果 oldLast 在断开之前是其所在层的最左节点，那么在断开之后，last 应该变为上一层的最右节点。
 * 情况二，如果 oldLast 在断开之前是 oldLast 的父节点的右孩子，那么在断开之后，last 应该变为 oldLast
 * 的父节点的左孩子。
 * 情况三，除情况一和情况二之外，还有一种情况。即 oldLast 并不是当前层的最左节点，也不是其父节点的右孩子，
 * 此时需要一个向上寻找的过程。先以 oldLast 作为当前节点，然后看当前节点是不是当前节点的父节点的右孩子，
 * 如果不是，就一直向上。直到当前节点是当前节点的父节点的右孩子，last 应该变为当前节点的父节点的左子树的最
 * 右节点。
 * 步骤 1）的具体过程请参看 MyHeap 类实现的 popLastAndSetPreviousLast 方法。
 * 2）断开 oldLast 节点后，堆中的元素少了一个，所以 size 减 1。如果 size 在减 1 之后有 size == 1，说
 * 明一开始堆的大小为 2，断开 oldLast 之后堆中只剩一个头节点。那么此时令 oldLast 作为新的头节点，并返回
 * 旧的头节点的值即可，代码如下：
 * Node<K> res = head;
 * Node<K> oldLast = popLastAndSetPreviousLast();
 * if (size == 1) {
 *     head = oldLast;
 *     last = oldLast;
 *     return res.value;
 * }
 * 3）如果断开 oldLast 节点后，size 依然大于 1。那么将 oldLast 设成新的头节点，然后从堆顶开始向下调整
 * 堆结构，即 heapify 的过程，此时依然要注意 head 和 last 可能改变的情况，因为调整的过程中新的头节点（
 * 即 oldLast）还可能会移动，使得 head 和 last 位置上的节点发生变化，具体过程请参看 MyHeap 类实现的
 * heapify 方法。
 *
 * MyHeap 类的设计就介绍完了，与经典的堆结构是一个数组结构不同的是，MyHeap 类是一个完全二叉树结构，所以
 * 两个相邻节点在交换位置时的处理会更复杂，都考虑彼此的拓扑关系，才能做到正确地进行交换。具体请参看 MyHeap
 * 类实现的 swapClosedTwoNodes 方法。当然也可以不进行结构上的交换，而只是交换两个节点的值，即 Node.value。
 * add 和 popHead 方法的所有操作都是在完全二叉树的一条或两条路径上进行的操作，所以每一个操作的代价都是完
 * 全二叉树的高度级别，一个节点数为 N 的完全二叉树高度为 O(logN)，所以 add 和 popHead 方法的时间复杂度
 * 为 O(logN)。
 *
 * @author Jiajing Li
 * @date 2019-07-20 21:41:20
 */
public class Main {

    public static void main(String[] args) {
        Comparator<Integer> comp = Comparator.naturalOrder();
        MyHeap<Integer> myHeap = new MyHeap<>(comp);
        myHeap.add(3);
        System.out.println("head = " + myHeap.getHead() + "，size = " + myHeap.getSize());
        myHeap.add(1);
        System.out.println("head = " + myHeap.getHead() + "，size = " + myHeap.getSize());
        myHeap.add(2);
        System.out.println("head = " + myHeap.getHead() + "，size = " + myHeap.getSize());
        myHeap.add(5);
        System.out.println("head = " + myHeap.getHead() + "，size = " + myHeap.getSize());
        myHeap.add(4);
        System.out.println("head = " + myHeap.getHead() + "，size = " + myHeap.getSize());
    }

}
