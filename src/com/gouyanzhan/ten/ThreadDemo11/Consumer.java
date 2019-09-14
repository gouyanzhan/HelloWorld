package com.gouyanzhan.ten.ThreadDemo11;

import java.util.Queue;

/**
 * @author Yanzhan Gou
 * @date 2019-08-22 16:11:17
 */
class Consumer extends Thread {
    Queue q;
    Consumer(Queue q){
        this.q = q;
    }
    //@Override
    //public void run(){
    //    while (true){
    //        q.get();
    //    }
    //}

}
