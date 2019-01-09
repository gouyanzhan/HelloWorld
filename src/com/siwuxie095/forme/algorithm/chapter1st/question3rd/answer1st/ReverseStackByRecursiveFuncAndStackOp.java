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
 * @date 2019-01-09 15:45:40
 */
public class ReverseStackByRecursiveFuncAndStackOp {
    /**
     * 返回栈底元素，并移除
     */
    public static int getAndRemoveLastElement(Stack<Integer> stack) {

        int result = stack.pop();

        // 判空：递归到栈底时，直接返回，不再压入栈底元素，相当于移除
        if (stack.isEmpty()) {
            return result;
        } else {

            int last = getAndRemoveLastElement(stack);
            // 把除了栈底元素之外的元素重新按正序压入栈中
            stack.push(result);
            return last;
        }
    }


    public static void reverse(Stack<Integer> stack) {

        if (stack.isEmpty()) {
            return;
        }

        // 返回当前栈底元素
        int i = getAndRemoveLastElement(stack);
        // 递归调用
        reverse(stack);
        // 逆序压入元素
        stack.push(i);
    }
}
