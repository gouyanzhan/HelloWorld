package com.gouyanzhan.seven.example2;

/**
 * @author Yanzhan Gou
 * @date 2019-09-15 19:22:14
 */
class Tiger implements Mammal{
    String name;
    public Tiger(String nm){
        name = nm;
    }
    @Override
    public void run() {
        System.out.println(name + "The tiger run");
    }

    @Override
    public void sleep() {
        System.out.println(name + "The tiger sleep");

    }

    @Override
    public void eat() {
        System.out.println(name + "The tiger eat");

    }

    @Override
    public void breath() {
        System.out.println(name + "The tiger breath");

    }
}

