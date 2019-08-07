package com.siwuxie095.forme.designpattern.summary.pattern1st.strategy.example1st;

/**
 * 不会叫
 *
 * @author Jiajing Li
 * @date 2019-08-07 22:09:07
 */
class MuteQuack implements QuackBehavior {

    /**
     * 名为呱呱叫，其实不出声
     */
    @Override
    public void quack() {
        // 什么都不做，不会叫
        System.out.println("不会叫");
    }
}
