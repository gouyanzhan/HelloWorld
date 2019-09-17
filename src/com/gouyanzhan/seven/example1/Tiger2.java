package com.gouyanzhan.seven.example1;

/**
 * @author Yanzhan Gou
 * @date 2019-09-15 19:06:06
 */
public class Tiger2 implements Mammal{
   //实现sleep方法
    @Override
    public void sleep() {
        System.out.println("The tiger sleep");
    }
    //实现eat方法
    @Override
    public void eat() {
        System.out.println("The tiger eat");
    }

    //实现breath 方法
    @Override
    public void breath(){
        System.out.println("The tiger breath");
    }
    //实现run方法
    @Override
    public void run() {
        System.out.println("The tiger run");
    }
    public static void main(String[] args){
        Tiger2 tiger2 = new Tiger2();
        tiger2.breath();
        tiger2.eat();
        tiger2.sleep();
        tiger2.run();
    }
}
