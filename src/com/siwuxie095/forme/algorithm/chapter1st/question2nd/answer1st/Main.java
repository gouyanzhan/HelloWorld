package com.siwuxie095.forme.algorithm.chapter1st.question2nd.answer1st;

/**
 * 由两个栈组成的队列
 *
 * 题目：
 * 编写一个类，用两个栈实现队列，支持队列的基本操作（add、poll、peek）
 *
 * 解答：
 * 栈是先进后出，队列是先进先出，用两个栈正好能把顺序反过来实现类似队列的操作。
 * 即 一个栈作为压入栈，在压入数据时（入队），只往这个栈中压入，记为 stackPush，
 * 另一个栈只作为弹出栈，在弹出数据时（出队），只从这个栈中弹出，记为 stackPop
 *
 * 注意：
 * 1、如果 stackPush 要往 stackPop 中压入数据，那么必须一次性把 stackPush 中的
 * 数据全部压入
 * 2、如果 stackPop 不为空，stackPush 绝对不能向 stackPop 中压入数据
 *
 * @author Jiajing Li
 * @date 2019-01-17 10:06:58
 */
public class Main {

    public static void main(String[] args) {

        TwoStacksQueue queue = new TwoStacksQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println("------------------");

        queue.add(4);
        queue.add(5);
        queue.add(6);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println("------------------");

        queue.add(7);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println("------------------");

        System.out.println(queue.peek());
        System.out.println(queue.poll());
        // 下面即将抛异常 Queue is empty.
        System.out.println(queue.peek());
        System.out.println(queue.poll());

    }

}
