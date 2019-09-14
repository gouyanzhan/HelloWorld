package com.siwuxie095.forme.designpattern.summary.pattern1st.strategy.example1st;

/**
 * 吱吱叫
 *
 * @author Jiajing Li
 * @date 2019-08-07 22:08:57
 */
class Squeak implements QuackBehavior {

    /**
     * 名为呱呱叫，其实是吱吱叫
     */
    @Override
    public void quack() {
        // 橡皮鸭子吱吱叫
        System.out.println("吱吱叫");
    }
}
