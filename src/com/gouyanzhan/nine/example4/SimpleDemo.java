package com.gouyanzhan.nine.example4;

/**
 * @author Yanzhan Gou
 * @date 2019-08-07 11:42:33
 */
public class SimpleDemo {
    public static void main(String[] args){
        String str = null;
        int strLength = 0;
        try{
            strLength = str.length();
            System.out.println("出现异常语句之后");
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        System.out.println("程序退出");
    }

}
