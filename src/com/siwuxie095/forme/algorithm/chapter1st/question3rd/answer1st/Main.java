package com.siwuxie095.forme.algorithm.chapter1st.question3rd.answer1st;

import java.util.Stack;

/**
 * 如何仅使用递归函数和栈操作逆序一个栈
 *
 * 递归函数：Recursive Function，栈操作：Stack Operation
 *
 * 题目：
 * 一个栈依次压入 1、2、3、4、5，则从栈顶到栈底分别为 5、4、3、2、1，
 * 将栈转置后，从栈顶到栈底分别为 1、2、3、4、5，即 实现栈中元素的逆
 * 序，但只能用递归函数来实现，不能使用其它数据结构
 *
 * 解答：
 * 需要设计两个递归函数，一个将栈底元素返回并移除，另一个接收返回值，
 * 并压栈，实现逆序
 *
 * @author Jiajing Li
 * @date 2019-01-18 15:46:02
 */
public class Main {

    public static void main(String[] args) {
        Stack<Integer> stack = initStack();
        System.out.println("逆序前：");
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
        System.out.println("-------------");
        stack = initStack();
        ReverseStackByRecursiveFuncAndStackOp.reverse(stack);
        System.out.println("逆序后：");
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

    private static Stack<Integer> initStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        return stack;
    }

}
