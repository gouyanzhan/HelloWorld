package com.gouyanzhan.ten.ThreadDemo12;

/**
 * @author Yanzhan Gou
 * @date 2019-08-22 16:15:39
 */
class Queue {
    //声明并初始化整数类型数据域value
    int value = 0;
    //声明并初始化布尔类型数据域isEmpty，用于判断队列的状态
    boolean isEmpty = true;
    //生产者生产方法
    public synchronized void put(int v){
        //如果共享数据没有被消费，则生产者等待
        if (!isEmpty){
            try {
                System.out.println("生产者等待");
                //进入等待状态
                wait();
            }
            //捕获异常
            catch (Exception e){
                //异常信息输出
                e.printStackTrace();
            }
        }
        //value值加v
        value += v;
        //isEmpty赋值为false
        isEmpty = false;
        //输出字符串信息
        System.out.println("生产者共生产数量：" + v);
        //生产之后通知消费者消费
        notify();
    }
    //消费者消费的方法
    public synchronized int get(){
        //消费者消费前，如果共享数据已经被消费完，则消费者等待
        if (isEmpty){
            try {
                //输出字符串信息
                System.out.println("消费者等待");
                //进入等待状态
                wait();
            }
            //捕获异常
            catch (Exception e){
                //异常信息输出
                e.printStackTrace();
            }
        }
        //value值-1
        value--;
        if (value < 1){
            //isEmpty赋值true
            isEmpty = true;
        }
        //输出信息
        System.out.println("消费者消费一个，剩余："+value);
        //消费者消费后，通知生产者生产
        notify();
        //返回value
        return value;
    }

}
