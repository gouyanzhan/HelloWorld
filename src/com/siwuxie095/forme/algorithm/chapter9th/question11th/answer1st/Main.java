package com.siwuxie095.forme.algorithm.chapter9th.question11th.answer1st;

/**
 * 设计 RandomPool 结构
 *
 * 题目：
 * 设计一种结构，在该结构中有如下三个功能：
 * （1）insert(key)：将某个 key 加入到该结构中，做到不重复加入。
 * （2）delete(key)：将原本在结构中的某个 key 移除。
 * （3）getRandom()：等概率随机返回结构中的任何一个 key。
 *
 * 要求：
 * insert、delete 和 getRandom 方法的时间复杂度都是 O(1)。
 *
 * 解答：
 * 这种结构假设叫 Pool，具体实现如下：
 * 1、包含两个哈希表 keyIndexMap 和 indexKeyMap。
 * 2、keyIndexMap 用来记录 key 到 index 的对应关系。
 * 3、indexKeyMap 用来记录 index 到 key 的对应关系。
 * 4、包含一个整数 size，用来记录目前 Pool 的大小，初始时 size 为 0。
 * 5、执行 insert(newKey) 操作时，将 (newKey, size) 放入 keyIndexMap 中，
 * 将 (size, newKey) 放入 indexKeyMap，然后将 size 加 1，即 每次执行 insert
 * 操作之后，size 自增。
 * 6、执行 delete(deleteKey) 操作时（关键步骤），假设 Pool 最新加入的 key 记
 * 为 lastKey，lastKey 对应的 index 信息记为 lastIndex。要删除的 key 记为
 * deleteKey，对应的 index 信息记为 deleteIndex。那么先把 lastKey 的 index
 * 信息换成 deleteKey，即 在 keyIndexMap 中把 (lastKey, lastIndex) 变为
 * (lastKey, deleteIndex)，并在 indexKeyMap 中把记录 (deleteIndex, deleteKey)
 * 变为 (deleteIndex, lastKey)。然后在 keyIndexMap 中删除记录 (deleteKey,
 * deleteIndex)，并在 indexKeyMap 中把记录 (lastIndex, lastKey) 删除。最后
 * size 减 1。这么做相当于把 lastKey 放到了 deleteKey 的位置上，保证记录的
 * index 还是连续的。
 * 7、进行 getRandom 操作时，根据当前的 size 随机得到一个 index，步骤 6 可保证
 * index 在范围 [0, size-1] 上，都对应着有效的 key，然后把 index 对应的 key
 * 返回即可。
 *
 * @author Jiajing Li
 * @date 2019-06-30 15:59:52
 */
public class Main {

    public static void main(String[] args) {
        Pool<String> pool = new Pool<>();
        pool.insert("A");
        pool.insert("B");
        pool.insert("C");
        pool.insert("D");
        pool.insert("E");
        System.out.println(pool.getRandom());

        pool.delete("F");
        System.out.println(pool.getRandom());

        pool.delete("A");
        System.out.println(pool.getRandom());
    }

}
