package com.siwuxie095.forme.algorithm.chapter9th.question29th.answer2nd;

/**
 * 出现次数的 TopK K 问题
 *
 * 进阶题目：
 * 设计并实现 TopKRecord 结构，可以不断地向其中加入字符串，并且可以根据字符串出现的情况随时打印
 * 加入次数最多前 k 个字符串，具体为：
 * 1、k 在 TopKRecord 实例生成时指定，并且不再变化（k 是构造函数的参数）。
 * 2、含有 add(String str) 方法，即向 TopKRecord 中加入字符串。
 * 3、含有 printTopK() 方法，即打印加入次数最多的前 k 个字符串，打印有哪些字符串和对应的次数即
 * 可，不要严格按排名顺序打印。
 *
 * 比如：
 * // 打印 Top 2 的结构
 * TopKRecord record = new TopKRecord(2);
 * record.add("A");
 * record.printTopK();
 * 此时打印：
 *      TOP:
 *      Str: A Times: 1
 * record.add("B");
 * record.add("B");
 * record.printTopK();
 * 此时打印：
 *      TOP:
 *      Str: A Times: 1
 *      Str: B Times 2
 * 或者打印：
 *      TOP:
 *      Str: B Times: 2
 *      Str: A Times: 1
 * record.add("C");
 * record.add("C");
 * record.printTopK();
 * 此时打印：
 *      TOP:
 *      Str: B Times: 2
 *      Str: C Times: 2
 * 或者打印：
 *      TOP:
 *      Str: C Times: 2
 *      Str: B Times: 2
 *
 * 要求：
 * 1、在任何时刻，add 方法的时间复杂度不超过 O(logk)。
 * 2、在任何时刻，printTopK 方法的时间复杂度不超过 O(k)。
 *
 * 解答：
 * 进阶问题。原问题是已经不再变化的字符串数组，所以可以一次性统计词频哈希表，然后建小根堆。可是进阶
 * 问题不一样，每个字符串词频可能会随时增加，这个过程一直是动态的。当然也可以在加入一个字符串时，在
 * 词频哈希表中增加这种字符串的词频，这样，add 方法的时间复杂度就是 O(1)。可是当有 printTopK 操
 * 作时，你只能像原问题一样，根据所有字符串的词频表建立小根堆，假设此时哈希表的记录数为 N，那么
 * printTopK 方法的时间复杂度就成了 O(N*logk)，但明显是不达标的。这里提供的解法依然是利用小根堆
 * 这个数据，但在设计上更复杂。下面介绍 TopKRecord 的结构设计。
 * TopKRecord 结构重要的 4 个部分如下：
 * （1）依然有一个小根堆 heap。小根堆里装的依然是原问题中 Node 类的实例，每个实例表示一个字符串及
 * 其词频统计的信息。小根堆里装的都是加入过的所有字符串中词频最高的 Top K。heap 的大小在初始化时就
 * 确定，是 Node 类型的数组结构，数组的总大小为 k。
 * （2）整型变量 index。表示如果新的 Node 类的实例想加入到 heap，该放在 heap 的哪个位置。
 * （3）哈希表 strNodeMap。key 为字符串类型，表示加入的某种字符串。value 为 Node 类型。strNodeMap
 * 上的每条信息表示一种字符串及其所对应的 Node 实例。
 * （4）哈希表 nodeIndexMap。key 为 Node 类型，表示一种字符串及其词频信息。value 为整型，表示
 * key 这个 Node 类的实例对应到 heap 上的位置，如果不在 heap 上，为 -1。
 *
 * 关于 strNodeMap 和 nodeIndexMap 的说明如下：
 * 比如，"A" 这个字符串加入了 10 次，那么在 strNodeMap 表中就会有类似这样的记录 (key = "A",
 * value = ("A", 10))，value 是一个 Node 类的实例。如果 "A" 加入的次数很多，使 "A" 成为加入
 * 的所有字符中词频最高的 Top K 之一，那么 "A" 应该在堆上。假设 "A" 在堆上的位置为 5，那么在
 * nodeIndexMap 表中就会有类似这样的记录 (key = ("A", 10), value = -1)。strNodeMap 是字
 * 符串及其所对应的 Node 实例信息的哈希表，nodeIndexMap 是字符串的 Node 实例信息对应在堆中（heap）
 * 位置的哈希表。
 * 以下为当加入一个字符串时，TopKRecord 类中 add 方法所做的事情：
 * 1、当加入一个字符串时，假设为 str。首先在 strNodeMap 中查询 str 之前出现的词频，如果查不到，
 * 说明 str 为第一次出现，在 strNodeMap 中加入一条记录(key = str, value = (str, 1))。如果
 * 可以查到，说明 str 之前出现过，此时需要把 str 的词频增加，假设之前出现过 10 次，那么查到的记
 * 录为 (key = str, value = (str, 10))，变更为 (key = str, value = (str, 11))。
 * 2、建立或调整完 str 的 Node 实例信息之后，需要考虑这个 Node 的实例信息是否已经在堆上，通过查
 * 询 nodeIndexMap 表可以得到 Node 实例对应的堆上的位置，如果没有或者查询结果为 -1，表示不在堆
 * 上，否则表示在堆上，位置记为 pos。
 * 1）如果在堆上，说明 str 词频没增加之前就是 Top K 之一，现在词频既然增加了，就需要考虑调整 str
 * 对应的 Node 的实例信息在堆中的位置，从 pos 位置开始向下调整小根堆即可（heapify）。特别注意：
 * 为了保证 nodeIndexMap 表中位置信息的始终准确，调整堆时，每一次两个堆元素（Node 实例）之间的
 * 位置交换都要更新在 nodeIndexMap 表中的位置。比如，在堆上的一个 Node 实例 ("A", 10) 原来在
 * 2 位置，在 nodeIndexMap 表中的信息为 (key = ("A", 10), value = 2)。现在又加入一个 "A"，
 * 词频增加，信息当然要变成 (key = ("A", 11), value = 2)。然后从位置 2 调整堆时，发现这个实例
 * 需要和自己的一个孩子实例 ("B", 10) 交换，假设这个 Node 实例的位置是 6，即在 nodeIndexMap
 * 表中记录为 (key = ("B", 10), value = 6)。那么在彼此交换位置之后，在 heap 数组中的两个实例
 * 当然很容易互换位置，但同时在 nodeIndexMap 上各自的信息也要变更，分别变更为 (key = ("A", 11),
 * value = 6) 和 (key = ("B", 10), value = 2)。也就是说，任何 Node 实例在堆中的位置调整都要
 * 改相应的 nodeIndexMap 表信息，这也是整个 TopKRecord 结构设计中最关键的逻辑。
 * 2）如果不在堆中，则看当前的小根堆是否已满（index ?= k）。如果没有满（index < k），那么把 str
 * 的 Node 实例放入堆底（heap 的 index 位置），自然也要在 nodeIndexMap 表中加上位置信息。然后
 * 做堆在插入时的调整（heapInsert），同样，任何交换都要改 nodeIndexMap 表。如果已满（index = k），
 * 则看 str 的词频是否大于小根堆堆顶的词频（heap[0]），如果不大于，则什么都不做。如果大于堆顶的词
 * 频，把 str 的 Node 实例设为新的堆顶，然后从位置 0 开始向下调整堆（heapify），同样，任何堆中位
 * 置的变更都要改 nodeIndexMap 表。
 * 3、过程结束。
 *
 * 在加入新字符串时，都可能会调整堆，而堆最大也仅是 k 的大小，所以 add 方法时间复杂度为 O(logK)。
 * 随时更新的小根堆就是每时每刻的 Top K，打印时又没有排序的要求，所以 printTopK 方法直接依次打印
 * 小根堆数组即可，时间复杂度为 O(K)。
 *
 * @author Jiajing Li
 * @date 2019-07-26 22:50:57
 */
public class Main {

    public static void main(String[] args) {
        TopKRecord record = new TopKRecord(2);
        record.add("A");
        record.printTopK();
        record.add("B");
        record.add("B");
        record.printTopK();
        record.add("C");
        record.add("C");
        record.printTopK();
    }

}
