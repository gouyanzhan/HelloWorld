package com.siwuxie095.forme.algorithm.chapter5th.question2nd.answer1st;

/**
 * 字符串中数字子串的求和
 *
 * 题目：
 * 给定一个字符串 str，求其中全部数字串所代表的数字之和。
 *
 * 要求：
 * 1、忽略小数点字符，例如 "A1.3"，其中包含两个数字 1 和 3。
 * 2、如果紧贴数字子串的左侧出现字符 "-"，当连续出现的数量为奇数时，则数字视为负，
 * 连续出现的数量为偶数时，则数字视为正。例如，"A-1BC--12"，其中包含数字 -1 和
 * 12。
 *
 * 比如：
 * str = "A1CD2E33"，返回 36。
 * str = "A-1B--2C--D6E"，返回 7。
 *
 * 解答：
 * 解决本题能做到时间复杂度为 O(N)、额外空间复杂度为 O(1) 的方法有很多。这里仅
 * 提供一种以作参考。解法的关键是如何从左到右遍历 str 时，准确收集每个数字并累加
 * 起来。具体过程如下：
 * 1、生成三个变量。整型变量 res，表示目前的累加和；整型变量 num，表示当前收集到
 * 的数字；布尔型变量 posi，表示如何把 num 累加到 res 里，num 是正还是负。初始
 * 时，res = 0，num = 0， posi = true。
 * 2、从左到右遍历 str，假设遍历到字符 cha，根据具体的 cha 有不同的处理。
 * 3、如果 cha 是 '0'～'9'，cha - '0' 的值记为 curr，假设之前收集的数字为 num，
 * 此时举例说明。比如 str = "123"，初始时 num = 0，posi = true。 当 cha ==
 * '1' 时，num 变成 1；cha == '2' 时，num 变成 12；cha == '3' 时，num 变成
 * 123。再如 str = "-123"，初始时 num = 0，posi = true。当 cha == '-' 时，
 * posi 变成 false，cha 不是 '0'～'9' 的情况接下来会说明，这里可以先认为在收集
 * 数字时 posi 的符号一定时正确的。 cha == '1' 时，num 变成 -1；cha == '2' 时，
 * num 变成 -12；cha == '3' 时，num 变成 -123。总之：
 * num = num * 10 + (posi ? curr : -curr)。
 * 4、如果 cha 不是 '0'～'9'，此时不管 cha 具体是什么，都是累加时，令 res += num，
 * 然后令 num = 0，累加完 num 当然要清零。累加完成后，再看 cha 具体的情况。如果 cha
 * 不是字符 '-'，令 posi = true，即如果 cha 既不是数字字符，也不是 '-' 字符，posi
 * 都变为 true。如果 cha 时字符 '-'，此时看 cha 的前一个字符，如果前一个字符也是 '-'
 * 字符，则 posi 改变符号，即 posi = !posi，否则令 posi = false。
 * 5、既然把累加的时机放在令 cha 不是数字字符的时候，那么如果 str 是以数字字符结尾的，
 * 会出现最后一个数字没有累加的情况。所以遍历完成后，令 res += num，防止最后的数字累
 * 加不上的情况发生。
 * 6、最后返回 res。
 *
 * @author Jiajing Li
 * @date 2019-04-08 23:27:43
 */
public class Main {

    public static void main(String[] args) {
        String str = "A1CD2E33";
        System.out.println(Sum.numSum(str));
        str = "A-1B--2C--D6E";
        System.out.println(Sum.numSum(str));
    }

}
