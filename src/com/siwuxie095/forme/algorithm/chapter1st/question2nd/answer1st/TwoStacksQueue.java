package com.siwuxie095.forme.algorithm.chapter1st.question2nd.answer1st;

import java.util.Stack;

/**
 * @author Jiajing Li
 * @date 2019-01-09 15:40:33
 */
public class TwoStacksQueue {

    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public TwoStacksQueue() {
        stackPush = new Stack<Integer>();
        stackPop = new Stack<Integer>();
    }

    /**
     * 入队：将新元素插入队尾
     */
    public void add(int pushInt) {
        stackPush.push(pushInt);
    }

    /*
     * 出队：将队头从队列中删除，并返回队头
     */
    public int poll() {
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("Queue is empty.");
        } else if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }

        return stackPop.pop();
    }

    /**
     * 仅返回队头
     */
    public int peek() {
        if (stackPop.empty() && stackPush.empty()) {
            throw new RuntimeException("Queue is empty.");
        } else if (stackPop.empty()) {
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }

        return stackPop.peek();
    }
}
