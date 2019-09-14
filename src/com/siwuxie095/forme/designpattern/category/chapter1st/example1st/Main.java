package com.siwuxie095.forme.designpattern.category.chapter1st.example1st;

/**
 * @author Jiajing Li
 * @date 2019-08-05 20:27:57
 */
public class Main {

    /**
     * 模拟鸭子应用
     *
     * 利用继承来提供鸭子的行为，这会导致：
     * 1、代码在多个子类中重复。
     * 2、运行时的行为不容易改变。
     * 3、很难知道所有鸭子的全部行为。
     * 4、改变会牵一发而动全身，造成其他鸭子不想要的改变。
     *
     * 每当有新鸭子出现时，就必须去检查，是否需要覆盖 fly() 和 quack() 方法，
     * 因为并不是所有鸭子都具有飞和叫的行为，这简直是噩梦...
     */
    public static void main(String[] args) {

    }

}
