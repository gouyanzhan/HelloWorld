package com.siwuxie095.forme.algorithm.chapter1st.question6th.answer2nd;

import java.util.Stack;

/**
 * @author Jiajing Li
 * @date 2019-01-20 16:47:26
 */
public class SortHanoiTowerByStack {

    public enum Action {
        /**
         * 动作
         */
        No, LToM, MToL, MToR, RToM
    }

    public static int hanoiProblem(int num, String left, String mid, String right) {
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> midStack = new Stack<>();
        Stack<Integer> rightStack = new Stack<>();
        leftStack.push(Integer.MAX_VALUE);
        midStack.push(Integer.MAX_VALUE);
        rightStack.push(Integer.MAX_VALUE);
        for (int i = num; i > 0; i--) {
            leftStack.push(i);
        }
        Action[] record = {Action.No};
        int step = 0;
        while (rightStack.size() != num + 1) {
            step += fromStack2ToStack(record, Action.MToL, Action.LToM, leftStack, midStack, left, mid);
            step += fromStack2ToStack(record, Action.LToM, Action.MToL, midStack, leftStack, mid, left);
            step += fromStack2ToStack(record, Action.RToM, Action.MToR, midStack, rightStack, mid, right);
            step += fromStack2ToStack(record, Action.MToR, Action.RToM, rightStack, midStack, right, mid);
        }
        System.out.println("-----------------");
        while (!leftStack.empty()) {
            System.out.println(leftStack.pop());
        }
        System.out.println("-----------------");
        while (!rightStack.empty()) {
            System.out.println(rightStack.pop());
        }
        System.out.println("-----------------");
        return step;
    }

    public static int fromStack2ToStack(Action[] record, Action preNoAct, Action nowAct, Stack<Integer> fromStack, Stack<Integer> toStack, String from, String to) {
        if (record[0] != preNoAct && fromStack.peek() < toStack.peek()) {
            toStack.push(fromStack.pop());
            System.out.println("Move " + toStack.peek() + " from " + from + " to " + to);
            record[0] = nowAct;
            return 1;
        }
        return 0;
    }

}
