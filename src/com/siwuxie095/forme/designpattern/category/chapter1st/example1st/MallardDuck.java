package com.siwuxie095.forme.designpattern.category.chapter1st.example1st;

/**
 * 绿头鸭
 *
 * @author Jiajing Li
 * @date 2019-08-05 19:36:20
 */
class MallardDuck extends Duck {

    @Override
    void display() {
        // 外观是绿头
        System.out.println("外观是绿头");
    }
}
