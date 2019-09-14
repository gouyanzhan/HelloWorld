package com.gouyanzhan.ten.ThreadDemo11;

import java.util.Queue;

/**
 * @author Yanzhan Gou
 * @date 2019-08-22 16:04:49
 */
class Producer extends Thread {
    Queue q;
    Producer(Queue q){
        this.q = q;
    }
    //@Override
    //public void run(){
    //    for (int i = 1;i < 5;i++){
    //        q.put(i);
    //    }
    //}
}
