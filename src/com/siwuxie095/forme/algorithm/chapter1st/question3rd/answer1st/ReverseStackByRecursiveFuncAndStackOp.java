package com.siwuxie095.forme.algorithm.chapter1st.question3rd.answer1st;

import java.util.Stack;

/**
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
