package com.siwuxie095.forme.designpattern.summary.pattern8th.adapter.example1st;

/**
 * 鸭子测试驱动（客户）
 *
 * @author Jiajing Li
 * @date 2019-11-04 15:39:32
 */
class DuckTestDrive {

    /**
     * 客户是依据目标接口（鸭子）实现的
     */
    static void testDuck(Duck duck) {
        duck.quack();
        duck.fly();
    }

}
