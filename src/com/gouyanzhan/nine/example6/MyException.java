package com.gouyanzhan.nine.example6;

/**
 * @author Yanzhan Gou
 * @date 2019-08-07 14:50:32
 */
public class MyException extends Exception{
    MyException(){

    }
    MyException(String msg){
        //调用父类方法
        super(msg);
    }


}
