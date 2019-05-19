package com.siwuxie095.forme.algorithm.chapter7th.question6th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-05-19 17:34:43
 */
public class Num {

    public static int onceNum(int[] arr, int k) {
        int[] eO = new int[32];
        for (int i = 0; i != arr.length; i++) {
            setExclusiveOr(eO, arr[i], k);
        }
        int res = getNumFromKSysNum(eO, k);
        return res;
    }

    private static void setExclusiveOr(int[] eO, int value, int k) {
        int[] currKSysNum = getKSysNumFromNum(value, k);
        for (int i = 0; i != eO.length; i++) {
            eO[i] = (eO[i] + currKSysNum[i]) % k;
        }
    }

    private static int[] getKSysNumFromNum(int value, int k) {
        int[] res = new int[32];
        int index = 0;
        while (value != 0) {
            res[index++] = value % k;
            value = value / k;
        }
        return res;
    }

    private static int getNumFromKSysNum(int[] eO, int k) {
        int res = 0;
        for (int i = eO.length - 1; i != -1; i--) {
            res = res * k + eO[i];
        }
        return res;
    }

}
