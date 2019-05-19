package com.gouyanzhan.clazz;

/**
 * @author Yanzhan Gou
 * @date 2019-03-11 20:57:19
 */
public class OverloadDemoTest {
    public static void main(String[] args){
        OverloadDemo ov  = new OverloadDemo();
        ov.method();
        ov.method(4);
        ov.method(4.5D);
        ov.method("a string");
    }

}
