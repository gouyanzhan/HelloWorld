package com.siwuxie095.forme.algorithm.chapter9th.question1st.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-06-12 09:25:06
 */
public class Random {

    //region 原问题

    private static int rand1To5() {
        return (int) (Math.random() * 5) + 1;
    }

    public static int rand1To7() {
        int num = 0;
        do {
            num = (rand1To5() - 1) * 5 + rand1To5() - 1;
        } while (num > 20);
        return num % 7 + 1;
    }

    //endregion

    //region 补充问题

    private static int rand01p() {
        // 可随意改变 p
        double p = 0.83;
        return Math.random() < p ? 0 : 1;
    }

    private static int rand01() {
        int num;
        do {
            num = rand01p();
        } while (num == rand01p());
        return num;
    }

    private static int rand0To3() {
        return rand01() * 2 + rand01();
    }

    public static int rand1To6() {
        int num = 0;
        do {
            num = rand0To3() * 4 + rand0To3();
        } while (num > 11);
        return num % 6 + 1;
    }


    //endregion


    //region 进阶问题

    private static int rand1ToM(int m) {
        return (int) (Math.random() * m) + 1;
    }

    public static int rand1ToN(int n, int m) {
        int[] nSys = getMSysNum(n - 1, m);
        int[] randNum = getRanMSysNumLessN(nSys, m);
        return getNumFromMSysNum(randNum, m) + 1;
    }

    /**
     * 把 value 变成 m 进制数
     */
    private static int[] getMSysNum(int value, int m) {
        int[] res = new int[32];
        int index = res.length - 1;
        while (value != 0) {
            res[index--] = value % m;
            value = value / m;
        }
        return res;
    }

    /**
     * 等概率随机产生一个 0～nSys 范围的数，只不过是用 m 进制表达的
     */
    private static int[] getRanMSysNumLessN(int[] nSys, int m) {
        int[] res = new int[nSys.length];
        int start = 0;
        while (nSys[start] == 0) {
            start++;
        }
        int index = start;
        boolean lastEqual = true;
        while (index != nSys.length) {
            res[index] = rand1ToM(m) - 1;
            if (lastEqual) {
                if (res[index] > nSys[index]) {
                    index = start;
                    lastEqual = true;
                    continue;
                } else {
                    lastEqual = res[index] == nSys[index];
                }
            }
            index++;
        }
        return res;
    }

    /**
     * 把 m 进制数转成十进制数
     */
    private static int getNumFromMSysNum(int[] mSysNum, int m) {
        int res = 0;
        for (int i = 0; i != mSysNum.length; i++) {
            res = res * m + mSysNum[i];
        }
        return res;
    }

    //endregion

}
