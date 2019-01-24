package com.siwuxie095.forme.algorithm.chapter1st.question5th.answer1st;

import java.util.Stack;

/**
 * @author Jiajing Li
 * @date 2019-01-09 15:57:18
 */
public class SortStackByStack {

    public static void sortStackByStack(Stack<Integer> stack) {

        Stack<Integer> help = new Stack<>();

        while (!stack.isEmpty()) {

            int cur = stack.pop();

            while (!help.isEmpty() && help.peek() < cur) {
                stack.push(help.pop());
            }

            help.push(cur);
        }

        /*
         * 将 help 中的全部元素再逐一压入 stack，完成排序
         */
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }

    }

}
