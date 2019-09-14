package com.gouyanzhan.nine.example6;

/**
 * @author Yanzhan Gou
 * @date 2019-08-07 14:48:09
 */
public class TestMyException {
    public static void main(String[] args){
        //创建自己的异常类对象
        MyException mec = new MyException("这是我自定义的异常类");
        System.out.println(mec.getMessage());
        System.out.println(mec.toString());
    }

}
