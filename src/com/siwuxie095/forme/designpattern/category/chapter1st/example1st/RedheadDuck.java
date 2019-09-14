package com.siwuxie095.forme.designpattern.category.chapter1st.example1st;

/**
 * 红头鸭
 *
 * @author Jiajing Li
 * @date 2019-08-05 19:41:08
 */
class RedheadDuck extends Duck {

    @Override
    void display() {
        // 外观是红头
        System.out.println("外观是红头");
    }
}
