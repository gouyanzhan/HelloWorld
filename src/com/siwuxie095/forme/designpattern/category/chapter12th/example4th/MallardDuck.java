package com.siwuxie095.forme.designpattern.category.chapter12th.example4th;

/**
 * 绿头鸭
 *
 * @author Jiajing Li
 * @date 2019-11-10 09:15:36
 */
class MallardDuck implements Quackable {

    @Override
    public void quack() {
        System.out.println("Quack");
    }
}
