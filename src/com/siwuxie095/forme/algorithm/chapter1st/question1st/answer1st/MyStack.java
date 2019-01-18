package com.siwuxie095.forme.algorithm.chapter1st.question1st.answer1st;


import java.util.Stack;

/**
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
