package com.siwuxie095.forme.algorithm.chapter5th.question11th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-04-18 21:24:12
 */
public class Rotate {

    public static void rotateWord(char[] charArr) {
        if (null == charArr || charArr.length == 0) {
            return;
        }
        reverse(charArr, 0, charArr.length - 1);
        int l = -1;
        int r = -1;
        for (int i = 0; i < charArr.length; ++i) {
            if (charArr[i] != ' ') {
                l = (i == 0 || charArr[i - 1] == ' ') ? i : l;
                r = (i == charArr.length - 1 || charArr[i + 1] == ' ') ? i : r;
            }
            if (l != -1 && r != -1) {
                reverse(charArr, l, r);
                l = -1;
                r = -1;
            }
        }
        System.out.println(charArr);
    }

    private static void reverse(char[] charArr, int start, int end) {
        char tmp = 0;
        while (start < end) {
            tmp = charArr[start];
            charArr[start] = charArr[end];
            charArr[end] = tmp;
            start++;
            end--;
        }
    }

    public static void rotate1(char[] charArr, int size) {
        if (null == charArr || size <= 0 || size >= charArr.length) {
            return;
        }
        reverse(charArr, 0, size - 1);
        reverse(charArr, size, charArr.length - 1);
        reverse(charArr, 0, charArr.length - 1);
        System.out.println(charArr);
    }

    public static void rotate2(char[] charArr, int size) {
        if (null == charArr || size <= 0 || size >= charArr.length) {
            return;
        }
        int start = 0;
        int end = charArr.length - 1;
        int lpart = size;
        int rpart = charArr.length - size;
        int s = Math.min(lpart, rpart);
        int d = lpart - rpart;
        while (true) {
            exchange(charArr, start, end, s);
            if (d == 0) {
                break;
            } else if (d > 0) {
                start += s;
                lpart = d;
            } else {
                end -= s;
                rpart = -d;
            }
            s = Math.min(lpart, rpart);
            d = lpart - rpart;
        }
        System.out.println(charArr);
    }

    private static void exchange(char[] charArr, int start, int end, int size) {
        int i = end - size + 1;
        char tmp = 0;
        while (size-- != 0) {
            tmp = charArr[start];
            charArr[start] = charArr[i];
            charArr[i] = tmp;
            start++;
            i++;
        }
    }

}
