package com.gouyanzhan.nine.example5;

/**
 * @author Yanzhan Gou
 * @date 2019-08-07 14:22:03
 */
public class ThrowDemo {
    static void connect()throws ClassNotFoundException{
        try {
            Class.forName("");
        }catch (ClassNotFoundException e){
            System.out.println("方法中把异常再次抛出");
            throw e;
        }
    }
    public static void main(String[] args){
        try {
            connect();
        }catch (ClassNotFoundException e){
            System.out.println("主方法对异常进行处理");
        }
    }

}
