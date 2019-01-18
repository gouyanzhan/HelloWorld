package com.siwuxie095.forme.algorithm.chapter1st.question5th.answer1st;

import java.util.Stack;

/**
 * 用一个栈实现另一个栈的排序
 *
 * 题目：
 * 一个栈中元素的类型为整型，现在想将该栈从顶到底按从大到小的顺序排序，
 * 只许申请一个栈。除此之外，可申请新的变量，但不能申请额外的数据结构
 *
 * 解答：
 * 将要排序的栈记为 stack，申请的辅助栈记为 help，在 stack 上执行 pop
 * 操作，弹出的元素记为 cur
 *
 * 1、如果 cur 小于等于 help 的栈顶元素 或 help 为空，则将 cur 直接压入 help
 * 2、如果 cur 大于 help 的栈顶元素，则将 help 的栈顶元素逐一弹出，逐一
 * 压入 stack，直到 cur 小于或等于 help 的栈顶元素，再将 cur 压入 help
 *
 * 一直执行以上操作，直到 stack 中全部元素都压入到 help，最后将 help 中
 * 的全部元素逐一压入 stack，完成排序
 *
 * @author Jiajing Li
 * @date 2019-01-18 16:55:25
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("排序前：");
        Stack<Integer> stack = initStack();
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
        System.out.println("----------------");
        System.out.println("排序后：");
        stack = initStack();
        SortStackByStack.sortStackByStack(stack);
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

    private static Stack<Integer> initStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(3);
        stack.push(11);
        stack.push(100);
        stack.push(1);
        return stack;
    }

}
