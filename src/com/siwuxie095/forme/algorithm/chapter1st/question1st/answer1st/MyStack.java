package com.siwuxie095.forme.algorithm.chapter1st.question1st.answer1st;


import java.util.Stack;

/**
 * 设计一个有 getMin 功能的栈
 *
 * 题目：
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作
 *
 * 要求：
 * 1、pop、push、getMin 操作的时间复杂度都为 O(1)
 * 2、设计的栈类型可以使用现成的栈
 *
 * 解答：
 * 使用两个栈，一个用来保存当前栈中的元素，其功能和一个正常栈没有区别，
 * 记为 stackData，另一个栈用于保存每一步的最小值 stackMin
 *
 * 注意：从外部来看，依然是「一个」栈
 *
 * 这里是法一
 *
 * @author Jiajing Li
 * @date 2019-01-09 14:28:21
 */
public class MyStack {
    /*
     * 法一和法二的所有操作的时间复杂度都是 O(1)，空间复杂度都是 O(n)
     *
     * 区别：
     * 法一的 stackMin 压入时稍省空间，但弹出时稍费时间
     * 法二的 stackMin 压入时稍费空间，但弹出时稍省时间
     */

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack() {
        stackData = new Stack<Integer>();
        stackMin = new Stack<Integer>();
    }

    public void push(int newNum) {
        if (stackMin.isEmpty()) {
            stackMin.push(newNum);
        } else if (newNum <= this.getMin()) {
            stackMin.push(newNum);
        }

        stackData.push(newNum);
    }

    public int pop() {
        if (stackData.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }

        int value = stackData.pop();
        if (value == this.getMin()) {
            stackMin.pop();
        }
        return value;
    }

    public int getMin() {
        if (stackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty.");
        }
        return stackMin.peek();
    }

    /*
     * peek() 和 pop() 都返回了栈顶元素，区别在于：
     * 前者仅返回栈顶元素，后者还会弹出栈顶元素
     */
}
