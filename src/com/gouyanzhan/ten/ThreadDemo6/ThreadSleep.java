package com.gouyanzhan.ten.ThreadDemo6;

/**
 * @author Yanzhan Gou
 * @date 2019-08-21 17:55:55
 */
public class ThreadSleep {
    public static void main(String[] args){
        SubThread st = new SubThread("SubThread");
        st.start();
    }
}
