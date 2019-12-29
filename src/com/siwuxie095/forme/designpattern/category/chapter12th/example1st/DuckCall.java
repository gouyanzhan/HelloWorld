package com.siwuxie095.forme.designpattern.category.chapter12th.example1st;

/**
 * 鸭鸣器
 *
 * @author Jiajing Li
 * @date 2019-11-10 09:17:47
 */
class DuckCall implements Quackable {

    /**
     * 鸭鸣器会呱呱叫，但听起来并不十分像真的鸭叫声
     */
    @Override
    public void quack() {
        System.out.println("Kwak");
    }
}
