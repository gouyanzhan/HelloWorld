package com.siwuxie095.forme.algorithm.chapter5th.question4th.answer1st;

/**
 * 判断两个字符串是否互为旋转词
 *
 * 题目：
 * 如果一个字符串 str，把字符串 str 前面任意的部分挪到后面形成的字符串叫作 str 的旋转词。
 * 比如 str = "12345"，str 的旋转词有 "12345"、"23451"、"34512"、"45123"、"51234"。
 * 给定两个字符串 a 和 b，请判断 a 和 b 是否互为旋转词。
 *
 * 比如：
 * a = "cdab"，b = "abcd"，返回 true。
 * a = "1ab2"，b = "ab12"，返回 false。
 * a = "2ab1"，b = "ab12"，返回 true。
 *
 * 要求：
 * 如果 a 和 b 长度不一样，那么 a 和 b 必然不互为旋转词，可以直接返回 false。当 a 和 b
 * 长度一样，都为 N 时，要求解法的时间复杂度为 O(N)。
 *
 * 解答：
 * 本题的解法非常简单，如果 a 和 b 长度不一样，字符串 a 和 b 不可能互为旋转词。如果 a 和
 * b 长度一样，先生成一个大字符 b2，b2 是两个字符串 b 拼在一起的结果，即 b2 = b + b。然
 * 后看 b2 中是否包含字符串 a，如果包含，说明字符串 a 和 b 互为旋转词，否则说明两个字符串
 * 不互为旋转词。这是为什么呢？举例说明，假设 a = "cdab"，b = "abcd"。b2 = "abcdabcd"，
 * b2[0..3] == "abcd" 是 b 的旋转词，b2[1..4] == "bcda" 是 b 的旋转词 ...
 * b2[i...i+3] 都是 b 的旋转词。由此可见，如果一个字符串 b 长度为 N，在通过 b 生成的 b2
 * 中，任意长度为 N 的子串都是 b 的旋转词，并且 b2 中包含 b 的所有旋转词。
 *
 * isRotation() 方法中 getIndexOf() 函数的功能是如果 b2 中包含 a，则返回 a 在 b2 中的
 * 开始位置，如果不包含 a，则返回 -1，即 getIndexOf() 是解决匹配问题的函数，如果想让整个过
 * 程在 O(N) 的时间复杂度内完成，那么字符串匹配问题也需要在 O(N) 的时间复杂度内完成。这正是
 * KMP 算法做的事情，getIndexOf() 函数就是 KMP 算法的实现。
 *
 * @author Jiajing Li
 * @date 2019-04-11 09:22:32
 */
public class Main {

    public static void main(String[] args) {
        String a = "cdab";
        String b = "abcd";
        System.out.println(Rotation.isRotation(a, b));
        a = "1ab2";
        b = "ab12";
        System.out.println(Rotation.isRotation(a, b));
    }

}
