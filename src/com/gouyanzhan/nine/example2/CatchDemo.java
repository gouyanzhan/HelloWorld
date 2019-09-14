package com.gouyanzhan.nine.example2;

/**
 * @author Yanzhan Gou
 * @date 2019-08-07 11:07:51
 */
public class CatchDemo {
    public static void main(String[] args){
        try {
            int a = 15/0;
        }catch (ArithmeticException e){
            System.out.println("捕获 ArithmeticException 异常");
        }
        catch (Exception e)
        {
            System.out.println("捕获 Exception 异常");
        }
    }

}
