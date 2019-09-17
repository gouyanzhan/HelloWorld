package com.gouyanzhan.seven.example1;

/**
 * @author Yanzhan Gou
 * @date 2019-09-14 21:24:08
 */
class Tiger implements Animal {

    @Override
    public void sleep() {
        System.out.println("The tiger sleep");

    }

    @Override
    public void eat() {
        System.out.println("The tiger eat");

    }

    @Override
    public void breath() {
        System.out.println("The tiger breath");

    }
    public static void main(String[] args){
        Tiger tiger = new Tiger();
        tiger.breath();
        tiger.eat();
        tiger.sleep();
    }
}
