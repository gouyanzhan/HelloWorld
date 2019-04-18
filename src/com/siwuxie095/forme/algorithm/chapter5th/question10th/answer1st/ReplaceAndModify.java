package com.siwuxie095.forme.algorithm.chapter5th.question10th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-04-17 14:33:48
 */
public class ReplaceAndModify {

    /**
     * 替换
     */
    public static void replace(char[] charArr) {
        if (null == charArr || charArr.length == 0) {
            return;
        }
        int num = 0;
        int len = 0;
        for (len = 0; len < charArr.length && charArr[len] != 0; ++len) {
            if (charArr[len] == ' ') {
                num++;
            }
        }
        int j = len + num * 2 - 1;
        for (int i = len - 1; i > -1; --i) {
            if (charArr[i] != ' ') {
                charArr[j--] = charArr[i];
            } else {
                charArr[j--] = '0';
                charArr[j--] = '2';
                charArr[j--] = '%';
            }
        }
        System.out.println(charArr);
    }

    /**
     * 调整
     */
    public static void modify(char[] charArr) {
        if (null == charArr || charArr.length == 0) {
            return;
        }
        int j = charArr.length - 1;
        for (int i = charArr.length - 1; i > -1; --i) {
            if (charArr[i] != '*') {
                charArr[j--] = charArr[i];
            }
        }
        for (; j > -1; ) {
            charArr[j--] = '*';
        }
        System.out.println(charArr);
    }

}
