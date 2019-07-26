package com.siwuxie095.forme.algorithm.chapter9th.question29th.answer1st;

/**
 * 出现次数的 TopK K 问题
 *
 * 题目：
 * 给定 String 类型的数组 strArr，再给定整数 k，请严格按照排名顺序打印出现次数前 k 名的字符串。
 *
 * 比如：
 * strArr = ["1", "2", "3", "4"]，k = 2
 * No.1: 1, times: 1
 * No.2: 2, times: 1
 * 这种情况下，所有的字符串都出现一样多，随便打印任何两个字符串都可以。
 * strArr = ["1", "1", "2", "3"]，k = 2
 * 输出：
 * No.1: 1, times: 2
 * No.1: 2, times: 1
 * 或者输出：
 * No.1: 1, times: 2
 * No.2: 3, times: 1
 *
 * 要求：
 * 如果 strArr 长度为 N，时间复杂度为 O(N*logk)。
 *
 * 解答：
 * 原问题。首先遍历 strArr 并统计字符串的词频，例如，strArr = ["a", "b", "b", "a", "c"]，
 * 遍历后可以生成每种字符串及其相关词频的哈希表如下：
 * key（字符串）         value（相关词频）
 * "a"                  2
 * "b"                  2
 * "c"                  1
 * 用哈希表的每条信息可以生成 Node 类的实例。哈希表中有多少信息，就建立多少 Node 类的实例，并且
 * 依次放入堆中，具体过程为：
 * 1、建立一个大小为 k 的小根堆，这个堆放入的是 Node 类的实例。
 * 2、遍历哈希表的每条记录，假设一条记录为 (s, t)，s 表示一种字符串，s 的词频为 t，则生成 Node
 * 类的实例，记为 (str, times)。
 * 1）如果小根堆没有满，就直接将 (str, times) 加入堆，然后进行建堆调整（heapInsert 调整），堆
 * 中 Node 类实例之间都以词频（times）来进行比较，词频越小，位置越往上。
 * 2）如果小根堆已满，说明此时小根堆已经选出 k 个最高词频的字符串，那么整个小根堆的堆顶自然代表已
 * 经选出的 k 个最高词频的字符串中，字符串最低的那个。堆顶的元素记为 (headStr, minTimes)。如果
 * minTimes < times，说明字符串 str 有资格进入当前 k 个最高词频字符串的范围。而 headStr 应该
 * 被移出这个范围，所以把当前的堆顶 (headStr, minTimes) 替换成 (str, times)，然后从堆顶的位置
 * 进行堆的调整（heapify）。如果 minTimes >= times，说明字符串 str 没有资格进入当前 k 个最高
 * 词频字符串的范围，因为 str 的词频还不如目前选出的 k 个最高词频字符串中词频最少的那个，所以什么
 * 也不做。
 * 3、遍历完 strArr 之后，小根堆里就是所有字符串中 k 个最高词频的字符串，但要求严格按排名打印，所
 * 以还需要根据词频从大到小完成 k 个元素间的排序。
 * 遍历 strArr 建立哈希表的过程为 O(N)。哈希表中记录的条数最多为 N 条，每一条记录进堆时，堆的调整
 * 时间复杂度为 O(logk)，所以根据记录更新小根堆的过程为 O(N*logk)。k 条记录排序的时间复杂度为 O
 * (k*logk)。所以总的时间复杂度为 O(N) + O(N*logk) + O(k*logk)，即 O(N*logk)。
 *
 * @author Jiajing Li
 * @date 2019-07-26 22:03:33
 */
public class Main {

    public static void main(String[] args) {
        String[] arr = {"1", "2", "3", "4"};
        TopK.printTopKAndRank(arr, 2);
        System.out.println();

        String[] arr0 = {"1", "1", "2", "3"};
        TopK.printTopKAndRank(arr0, 2);
    }

}
