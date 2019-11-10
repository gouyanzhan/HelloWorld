package com.siwuxie095.forme.designpattern.category.chapter12th.example1st;

/**
 * 橡皮鸭
 *
 * @author Jiajing Li
 * @date 2019-11-10 09:19:32
 */
public class RubberDuck implements Quackable {

    /**
     * 橡皮鸭呱呱叫时，其实声音是吱吱叫
     */
    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}
