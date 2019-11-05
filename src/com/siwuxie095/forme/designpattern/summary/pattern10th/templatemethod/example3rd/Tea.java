package com.siwuxie095.forme.designpattern.summary.pattern10th.templatemethod.example3rd;

/**
 * 茶
 *
 * @author Jiajing Li
 * @date 2019-11-05 13:49:27
 */
class Tea extends CaffeineBeverageWithHook {


    /**
     * 用沸水浸泡茶叶
     */
    @Override
    void brew() {
        System.out.println("Steeping the tea");
    }

    /**
     * 加柠檬
     */
    @Override
    void addCondiments() {
        System.out.println("Adding Lemon");
    }

}
