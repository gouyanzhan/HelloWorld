package com.siwuxie095.forme.test.test011;

/**
 * @author Jiajing Li
 * @date 2019-04-18 17:55:50
 */
public class Main {

    /**
     * 说明的问题：正则表达式，参考链接：https://mp.weixin.qq.com/s/ejtbumkNZpaPSc4AP2XsoA
     *
     * 一、基础篇
     *
     * 1、元字符
     * .    匹配除换行符以外的任意字符（一个）
     * \w   匹配字母或数字或下划线或汉字（一个）
     * \s   匹配任意的空白符（一个）
     * \d   匹配数字（一个）
     * \b   匹配单词的开始或结束
     * ^    匹配字符串的开始
     * $    匹配字符串的结束
     *
     * PS：带反斜杠的注意转义（即多加一个反斜杠）
     *
     *
     * 2、重复限定符
     * *        重复零次或更多次
     * +        重复一次或更多次
     * ?        重复零次或一次
     * {n}      重复 n 次
     * {n,}     重复 n 次或更多次
     * {n,m}    重复 n 到 m 次
     *
     * PS：重复限定符是作用在与它左边最近的一个或一组字符
     *
     *
     * 3、分组
     * 正则表达式中用小括号 () 来做分组，也就是括号中的内容作为一个整体。
     *
     * 4、转义
     * 正则表达式用小括号来做分组，那么问题来了：如果要匹配的字符串中本身就包含小括号，那是不是冲突？应该怎么办？
     * 针对这种情况，正则提供了转义的方式，也就是要把这些元字符、限定符或者关键字转义成普通的字符，做法很简答，
     * 就是在要转义的字符前面加个反斜杠，也就是 \ 即可。
     *
     * 5、条件或
     * 正则用符号 | 来表示或，也叫做分支条件，当满足正则里的分支条件的任何一种条件时，都会当成是匹配成功。
     *
     * 6、区间
     * 正则提供一个元字符中括号 [] 来表示区间条件。
     * 限定0到9        可以写成[0-9]
     * 限定A-Z        写成[A-Z]
     * 限定某些数字     [165]
     */
    public static void main(String[] args) {
        //first();
        //second();
        //third();
        //fourth();
        fifth();
    }

    /**
     * 1、元字符
     * .    匹配除换行符以外的任意字符（一个）
     * \w   匹配字母或数字或下划线或汉字（一个）
     * \s   匹配任意的空白符（一个）
     * \d   匹配数字（一个）
     * \b   匹配单词的开始或结束
     * ^    匹配字符串的开始
     * $    匹配字符串的结束
     */
    private static void first() {
        /*
         * 匹配有 abc 开头的字符串
         */
        String startWithAbc1 = "\\babc.*";
        String startWithAbc2 = "^abc.*";
        System.out.println("123".matches(startWithAbc1));
        System.out.println("123".matches(startWithAbc2));
        System.out.println();
        System.out.println("abcde".matches(startWithAbc1));
        System.out.println("abcde".matches(startWithAbc2));
        System.out.println();
        System.out.println("acm".matches(startWithAbc1));
        System.out.println("acm".matches(startWithAbc2));
        System.out.println();

        /*
         * 匹配 8 位数字的 QQ 号码
         */
        String eightDigitQQ = "^\\d\\d\\d\\d\\d\\d\\d\\d$";
        System.out.println("1".matches(eightDigitQQ));
        System.out.println("a".matches(eightDigitQQ));
        System.out.println("啊".matches(eightDigitQQ));
        System.out.println("12345678".matches(eightDigitQQ));
        System.out.println("123456789".matches(eightDigitQQ));
        System.out.println();

        /*
         * 匹配 1 开头的 11 位数字的手机号码
         */
        String startWithOne = "^1\\d\\d\\d\\d\\d\\d\\d\\d\\d\\d$";
        System.out.println("1".matches(startWithOne));
        System.out.println("12345678901".matches(startWithOne));
        System.out.println("a".matches(startWithOne));
        System.out.println("啊".matches(startWithOne));
        System.out.println("，。".matches(startWithOne));
    }

    /**
     * 2、重复限定符
     * *        重复零次或更多次
     * +        重复一次或更多次
     * ?        重复零次或一次
     * {n}      重复 n 次
     * {n,}     重复 n 次或更多次
     * {n,m}    重复 n 到 m 次
     */
    private static void second() {
        /*
         * 匹配 8 位数字的 QQ 号码
         */
        String eightDigitQQ = "^\\d{8}$";
        System.out.println("1".matches(eightDigitQQ));
        System.out.println("a".matches(eightDigitQQ));
        System.out.println("啊".matches(eightDigitQQ));
        System.out.println("12345678".matches(eightDigitQQ));
        System.out.println("123456789".matches(eightDigitQQ));
        System.out.println();

        /*
         * 匹配 1 开头的 11 位数字的手机号码
         */
        String startWithOne = "^1\\d{10}$";
        System.out.println("1".matches(startWithOne));
        System.out.println("12345678901".matches(startWithOne));
        System.out.println("a".matches(startWithOne));
        System.out.println("啊".matches(startWithOne));
        System.out.println("，。".matches(startWithOne));
        System.out.println();

        String cardNumFrom14To18 = "^\\d{14,18}$";
        System.out.println("1234567890abcd".matches(cardNumFrom14To18));
        System.out.println("12345678901234".matches(cardNumFrom14To18));
        System.out.println("123456789012345678".matches(cardNumFrom14To18));
        System.out.println("a".matches(cardNumFrom14To18));
        System.out.println("啊".matches(cardNumFrom14To18));
        System.out.println();

        /*
         * 匹配以 a 开头的，0 个或多个 b 结尾的字符串
         */
        String startWithA = "^ab*$";
        System.out.println("a".matches(startWithA));
        System.out.println("abc".matches(startWithA));
        System.out.println("abbbb".matches(startWithA));
        System.out.println("abbbbc".matches(startWithA));
        System.out.println("啊".matches(startWithA));
        System.out.println("a啊".matches(startWithA));
        System.out.println();
    }

    /**
     * 3、分组
     * 正则表达式中用小括号 () 来做分组，也就是括号中的内容作为一个整体。
     */
    private static void third() {
        /*
         * 匹配字符串中包含 0 到多个 ab 开头
         */
        String startWithAB = "^(ab)*";
        System.out.println("".matches(startWithAB));
        System.out.println("12".matches(startWithAB));
        System.out.println("ab".matches(startWithAB));
        System.out.println("abab".matches(startWithAB));
        System.out.println("abcd".matches(startWithAB));
        System.out.println("啊".matches(startWithAB));
    }

    /**
     * 4、转义
     * 正则表达式用小括号来做分组，那么问题来了：如果要匹配的字符串中本身就包含小括号，那是不是冲突？应该怎么办？
     * 针对这种情况，正则提供了转义的方式，也就是要把这些元字符、限定符或者关键字转义成普通的字符，做法很简答，
     * 就是在要转义的字符前面加个反斜杠，也就是 \ 即可。
     */
    private static void fourth() {
        /*
         * 匹配以 (ab) 开头
         */
        String startWithAB = "^(\\(ab\\))*";
        System.out.println("".matches(startWithAB));
        System.out.println("(ab)".matches(startWithAB));
        System.out.println("(ab)(ab)".matches(startWithAB));
        System.out.println("(ab)123".matches(startWithAB));
        System.out.println("啊".matches(startWithAB));
    }

    /**
     * 5、条件或
     * 正则用符号 | 来表示或，也叫做分支条件，当满足正则里的分支条件的任何一种条件时，都会当成是匹配成功。
     */
    private static void fifth() {
        /*
         * 匹配联通的若干个号段开头的手机号码
         */
        String mobile = "^(130|131|132|155|156|185|186|145|176)\\d{8}$";
        System.out.println("13012345678".matches(mobile));
        System.out.println("1301234567a".matches(mobile));
        System.out.println("1301234567啊".matches(mobile));
        System.out.println("".matches(mobile));
    }

    /**
     * 6、区间
     * 正则提供一个元字符中括号 [] 来表示区间条件。
     * 限定0到9        可以写成[0-9]
     * 限定A-Z        写成[A-Z]
     * 限定某些数字     [165]
     */
    private static void sixth() {
        /*
         * 匹配联通的若干个号段开头的手机号码
         */
        String mobile = "^((13[0-2])|(15[56])|(18[5-6])|145|176)\\d{8}$";
        System.out.println("13012345678".matches(mobile));
        System.out.println("1301234567a".matches(mobile));
        System.out.println("1301234567啊".matches(mobile));
        System.out.println("".matches(mobile));
    }

}
