package com.gouyanzhan.six.example5;

/**
 * @author Yanzhan Gou
 * @date 2019-07-21 16:47:06
 */
 class Fish extends Animal{
    String fishType;
    void swim(){
        System.out.println("鱼在游泳");
    }
    @Override
    void breath(){
        System.out.println("鱼是用腮呼吸的");
    }
}
