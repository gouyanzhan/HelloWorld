package com.siwuxie095.forme.designpattern.category.chapter1st.example3rd;

/**
 * 狗
 *
 * @author Jiajing Li
 * @date 2019-08-05 21:32:58
 */
class Dog extends Animal {

    @Override
    void makeSound() {
        bark();
    }

    private void bark() {
        System.out.println("汪汪叫");
    }
}
