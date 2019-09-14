package com.siwuxie095.forme.designpattern.category.chapter1st.example4th;

/**
 * 不会叫
 *
 * @author Jiajing Li
 * @date 2019-08-05 23:20:50
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
