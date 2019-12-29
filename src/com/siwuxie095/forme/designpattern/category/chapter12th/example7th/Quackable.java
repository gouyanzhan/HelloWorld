package com.siwuxie095.forme.designpattern.category.chapter12th.example7th;

/**
 * 会呱呱叫的/能呱呱叫的
 *
 * @author Jiajing Li
 * @date 2019-11-10 09:13:20
 */
interface Quackable extends Observable {

    /**
     * 呱呱叫
     */
    void quack();

}
