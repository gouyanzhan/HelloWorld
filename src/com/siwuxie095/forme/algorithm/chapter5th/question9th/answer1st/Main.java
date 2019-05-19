package com.siwuxie095.forme.algorithm.chapter5th.question9th.answer1st;

/**
 * 在有序但含有空的数组中查找字符串
 *
 * 题目：
 * 给定一个字符串数组 strArr[]，在 strArr 中有些位置为 null，但在不为 null 的位置上，
 * 其字符串是按照字典顺序由小到大依次出现的。再给定一个字符串 str，请返回 str 在 strArr
 * 中出现的最左的位置。
 *
 * 比如：
 * strArr = [null, "a", null, "a", null, "b", null, "c"]，str = "a"，返回 1。
 * strArr = [null, "a", null, "a", null, "b", null, "c"]，str = null，返回 -1。
 * strArr = [null, "a", null, "a", null, "b", null, "c"]，str = "d"，返回 -1。
 *
 * 解答：
 * 本题的解法尽可能多地使用了二分查找，具体过程如下：
 * 1、假设在 strArr[left..right] 上进行查找的过程，全局整型变量 res 表示字符串 str
 * 在 strArr 中的最左的位置。初始时，left = 0，right = strArr.length-1，res = -1。
 * 2、令 mid = (left+right)/2，则 strArr[mid] 为 strArr[left..right] 中间位置的
 * 字符串。
 * 3、如果字符串 strArr[mid] 与 str 一样，说明找到了 str，令 res = mid。但要找的是最
 * 左的位置，所以还要在左半区寻找，看有没有更左的 str 出现，所以令 right = mid-1，然后
 * 重复步骤 2。
 * 4、如果字符串 strArr[mid] 与 str 不一样，并且 strArr[mid] != null，此时可以比较
 * strArr[mid] 和 str，如果 strArr[mid] 的字典顺序比 str 小，说明整个左半区不会出现
 * str，需要在右半区寻找，所以令 left = mid+1，然后重复步骤 2。
 * 5、如果字符串 strArr[mid] 与 str 不一样，并且 strArr[mid] == null，此时从 mid
 * 开始从右到左遍历左半区（即 strArr[left..mid]）。如果整个左半区都为 null，那么继续用
 * 二分的方式在右半区上查找（即令 left = mid+1），然后重复步骤 2。如果整个左半区不都为 null，
 * 假设从右到左遍历 strArr[left..mid] 时，发现第一个不为 null 的位置是 i，那么把 str
 * 和 strArr[i] 进行比较。如果 strArr[i] 字典顺序等于 str，说明找到 str，令 res = mid，
 * 但要找的是最左位置，所以还要在 strArr[left..i-1] 上寻找，看有没有更左的 str 出现，
 * 所以令 right = i-1，然后重复步骤 2。如果 strArr[i] 字典顺序大于 str，说明 strArr
 * [i..right] 上都没有 str，需要在 strArr[left..i-1] 上查找，所以令 right = i-1，
 * 然后重复步骤 2。
 *
 * @author Jiajing Li
 * @date 2019-04-16 20:47:38
 */
public class Main {

    public static void main(String[] args) {
        String[] strArr = new String[] {null, "a", null, "a", null, "b", null, "c"};
        System.out.println(Index.getIndex(strArr, "a"));
        System.out.println(Index.getIndex(strArr, null));
        System.out.println(Index.getIndex(strArr, "d"));
    }

}
