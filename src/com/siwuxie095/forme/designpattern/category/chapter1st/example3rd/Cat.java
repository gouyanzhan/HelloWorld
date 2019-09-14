package com.siwuxie095.forme.designpattern.category.chapter1st.example3rd;

/**
 * 猫
 *
 * @author Jiajing Li
 * @date 2019-08-05 21:33:04
 */
class Cat extends Animal {

    @Override
    void makeSound() {
        meow();
    }

    private void meow() {
        System.out.println("喵喵叫");
    }
}
