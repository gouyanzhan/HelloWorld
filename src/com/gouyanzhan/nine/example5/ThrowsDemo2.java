package com.gouyanzhan.nine.example5;

/**
 * @author Yanzhan Gou
 * @date 2019-08-07 14:36:12
 */
public class ThrowsDemo2 {
    static void amethod() throws IllegalAccessException {
        System.out.println("方法内抛出异常");
        throw new IllegalAccessException();
    }
    public static void main(String[] args){
      try {
          amethod();
      }catch (IllegalAccessException e){
          System.out.println("捕获到异常");
      }

    }

}
