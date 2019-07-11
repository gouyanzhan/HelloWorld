package com.siwuxie095.forme.algorithm.chapter9th.question16th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-07-06 16:34:49
 */
public class Times  {

    //region 法一

    public static int solution1(int num) {
        if (num < 1) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i != num + 1; i++) {
            count += getOneCount(i);
        }
        return count;
    }

    private static int getOneCount(int num) {
        int res = 0;
        while (num != 0) {
            if (num % 10 == 1) {
                res++;
            }
            num /= 10;
        }
        return res;
    }

    //endregion


    //region 法二

    public static int solution2(int num) {
        if (num < 1) {
            return 0;
        }
        int len = getLenOfNum(num);
        if (len == 1) {
            return 1;
        }
        int tmp = powerBaseOfTen(len - 1);
        int first = num / tmp;
        int firstOneNum = first == 1 ? (num % tmp + 1) : tmp;
        int otherOneNum = first * (len - 1) * (tmp / 10);
        return firstOneNum + otherOneNum + solution2(num % tmp);
    }

    private static int getLenOfNum(int num) {
        int len = 0;
        while (num != 0) {
            len++;
            num /= 10;
        }
        return len;
    }

    private static int powerBaseOfTen(int base) {
        return (int) Math.pow(10, base);
    }

    //endregion

}
