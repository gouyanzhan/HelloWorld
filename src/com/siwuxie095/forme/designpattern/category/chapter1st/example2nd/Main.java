package com.siwuxie095.forme.designpattern.category.chapter1st.example2nd;

/**
 * @author Jiajing Li
 * @date 2019-08-05 20:50:45
 */
public class Main {

    /**
     * 模拟鸭子应用
     *
     * 利用接口来提供鸭子的部分行为，即
     * 1、把 fly() 从超类中取出，放进一个 Flyable 接口中，只有会飞的鸭子才实现此接口。
     * 2、把 quack() 从超类中取出，放进一个 Quackable 接口中，因为不是所有的鸭子都会叫。
     *
     * 这种写法虽然可以解决一部分问题（不会再有会飞的橡皮鸭，也不会再有会飞会叫的诱饵鸭），
     * 但是却造成了代码无法复用，每一个会飞的鸭子都要去重新实现 fly() 方法。从一个噩梦
     * 跳进另一个噩梦...
     */
    public static void main(String[] args) {

    }

}
