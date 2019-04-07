package com.siwuxie095.forme.algorithm.chapter4th.question12th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-04-07 21:05:42
 */
public class Number {

    //region 暴力递归的方法

    public static int num1(String str) {
        if (null == str || "".equals(str)) {
            return 0;
        }
        char[] charArr = str.toCharArray();
        return process(charArr, 0);
    }

    private static int process(char[] charArr, int i) {
        if (i == charArr.length) {
            return 1;
        }
        if (charArr[i] == '0') {
            return 0;
        }
        int res = process(charArr, i + 1);
        if (i + 1 < charArr.length && (charArr[i] - '0') * 10 + charArr[i + 1] - '0' < 27) {
            res += process(charArr, i + 2);
        }
        return res;
    }
    //endregion


    //region 动态规划的方法

    public static int num2(String str) {
        if (null == str || "".equals(str)) {
            return 0;
        }
        char[] charArr = str.toCharArray();
        int curr = (charArr[charArr.length - 1] == '0') ? 0 : 1;
        int next = 1;
        int tmp = 0;
        for (int i = charArr.length - 2; i >= 0; --i) {
            if (charArr[i] == '0') {
                next = curr;
                curr = 0;
            } else {
                tmp = curr;
                if ((charArr[i] - '0') * 10 + charArr[i + 1] - '0' < 27) {
                    curr += next;
                }
                next = tmp;
            }
        }
        return curr;
    }
    //endregion

}
