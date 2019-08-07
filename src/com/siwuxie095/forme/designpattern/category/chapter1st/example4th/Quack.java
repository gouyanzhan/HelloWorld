package com.siwuxie095.forme.designpattern.category.chapter1st.example4th;

/**
 * 呱呱叫
 *
 * @author Jiajing Li
 * @date 2019-08-05 23:18:43
 */
class Quack implements QuackBehavior {

    /**
     * 真的呱呱叫
     */
    @Override
    public void quack() {
        // 实现鸭子呱呱叫
        System.out.println("呱呱叫");
    }
}
