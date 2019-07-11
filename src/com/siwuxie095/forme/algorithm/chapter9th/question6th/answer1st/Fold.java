package com.siwuxie095.forme.algorithm.chapter9th.question6th.answer1st;

/**
 * @author Jiajing Li
 * @date 2019-06-16 22:46:53
 */
public class Fold {

    public static void printAllFolds(int N) {
        printProcess(1, N, true);
    }

    private static void printProcess(int i, int N, boolean down) {
        if (i > N) {
            return;
        }
        printProcess(i + 1, N, true);
        System.out.println(down ? "down " : "up ");
        printProcess(i + 1, N, false);
    }

}
