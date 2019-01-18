package com.siwuxie095.forme.algorithm.chapter1st.question1st.answer2nd;

import com.siwuxie095.forme.algorithm.chapter1st.question1st.answer1st.MyStack;

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
 * 这里是法二
 *
 * @author Jiajing Li
 * @date 2019-01-16 16:07:08
 */
public class Main {

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(7);
        myStack.push(5);
        myStack.push(17);

        System.out.println("最小值：" + myStack.getMin());
        System.out.println("弹栈：" + myStack.pop());
        System.out.println("最小值：" + myStack.getMin());
        System.out.println("弹栈：" + myStack.pop());
        System.out.println("最小值：" + myStack.getMin());
        System.out.println("弹栈：" + myStack.pop());
        // 下面即将抛异常 Your stack is empty.
        System.out.println("最小值：" + myStack.getMin());
        System.out.println("弹栈：" + myStack.pop());
    }

}
