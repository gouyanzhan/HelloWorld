package com.siwuxie095.forme.algorithm.chapter5th.question7th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-04-13 13:34:02
 */
public class Count {

    //region 原问题

    public static String getCountString(String str) {
        if (null == str || "".equals(str)) {
            return "";
        }
        char[] charArr = str.toCharArray();
        String res = String.valueOf(charArr[0]);
        int num = 1;
        for (int i = 1; i < charArr.length; ++i) {
            if (charArr[i] != charArr[i - 1]) {
                res = concat(res, String.valueOf(num), String.valueOf(charArr[i]));
                num = 1;
            } else {
                num++;
            }
        }
        return concat(res, String.valueOf(num), "");
    }

    private static String concat(String s1, String s2, String s3) {
        return s1 + "_" + s2 + ("".equals(s3) ? s3 : ("_" + s3));
    }
    //endregion


    //region 补充问题

    public static char getCharAt(String countStr, int index) {
        if (null == countStr || "".equals(countStr)) {
            return 0;
        }
        char[] charArr = countStr.toCharArray();
        boolean stage = true;
        char curr = 0;
        int num = 0;
        int sum = 0;
        for (int i = 0; i != charArr.length; ++i) {
            if (charArr[i] == '_') {
                stage = !stage;
            } else if (stage) {
                sum += num;
                if (sum > index) {
                    return curr;
                }
                num = 0;
                curr = charArr[i];
            } else {
                num = num * 10 + charArr[i] - '0';
            }
        }
        return sum + num > index ? curr : 0;
    }
    //endregion

}
