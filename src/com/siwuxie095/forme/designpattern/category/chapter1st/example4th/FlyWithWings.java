package com.siwuxie095.forme.designpattern.category.chapter1st.example4th;

/**
 * 用翅膀飞
 *
 * @author Jiajing Li
 * @date 2019-08-05 23:16:38
 */
class FlyWithWings implements FlyBehavior {

    /**
     * 这里实现了所有有翅膀的鸭子飞行动作
     */
    @Override
    public void fly() {
        // 实现鸭子飞行
        System.out.println("用翅膀飞行");
    }
}
