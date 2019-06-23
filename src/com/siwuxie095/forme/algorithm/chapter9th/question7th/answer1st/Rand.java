package com.siwuxie095.forme.algorithm.chapter9th.question7th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-06-23 15:27:30
 */
public class Rand {

    /**
     * 一个简单的随机函数，决定一件事情做还是不做
     */
    private static int rand(int max) {
        return (int) (Math.random() * max) + 1;
    }

    public static int[] getKNumsRand(int k, int max) {
        if (max < 1 || k < 1) {
            return null;
        }
        int[] res = new int[Math.min(k, max)];
        for (int i = 0; i != res.length; i++) {
            // 前 k 个数直接进袋子
            res[i] = i + 1;
        }
        for (int i = k + 1; i < max + 1; i++) {
            // 决定 i 进不进袋子
            if (rand(i) <= k) {
                // i 随机替掉袋子中的一个
                res[rand(k) - 1] = i;
            }
        }
        return res;
    }

}
