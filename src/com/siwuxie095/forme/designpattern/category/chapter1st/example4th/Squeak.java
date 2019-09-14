package com.siwuxie095.forme.designpattern.category.chapter1st.example4th;

/**
 * 吱吱叫
 *
 * @author Jiajing Li
 * @date 2019-08-05 23:19:36
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
