package com.gouyanzhan.six.example5;

/**
 * @author Yanzhan Gou
 * @date 2019-07-21 16:48:13
 */
public class UseAbstract {
    public static void main(String[] args){
        Animal animal1 = new Fish();
        animal1.breath();
        Animal animal2 = new Tiger();
        animal2.breath();
        ((Fish)animal1).swim();
        ((Tiger)animal2).tigerRun();
    }

}
