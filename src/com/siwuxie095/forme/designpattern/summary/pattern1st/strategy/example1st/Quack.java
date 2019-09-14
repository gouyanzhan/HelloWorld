package com.siwuxie095.forme.designpattern.summary.pattern1st.strategy.example1st;

/**
 * 呱呱叫
 *
 * @author Jiajing Li
 * @date 2019-08-07 22:08:42
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
