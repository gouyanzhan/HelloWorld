package com.siwuxie095.foryou.clazz;

/**
 * @author Jiajing Li
 * @date 2019-02-28 22:28:19
 */
public class PassByValueTest {

    /*
     * 形式参数：是在定义函数名和函数体的时候使用的参数,
     * 目的是用来接收调用该函数时传入的参数。
     *
     * 实际参数：在调用有参函数时，主调函数和被调函数之间
     * 有数据传递关系。在主调函数中调用一个函数时，函数名
     * 后面括号中的参数称为“实际参数”。
     */

    /*
     * 错误的说法：
     *
     * 值传递（pass by value）是指在调用函数时将实际参数复制一份传递到函数中，这样在函数
     * 中如果对参数进行修改，将不会影响到实际参数。
     *
     * 引用传递（pass by reference）是指在调用函数时将实际参数的地址直接传递到函数中，那
     * 么在函数中对参数所进行的修改，将影响到实际参数。
     *
     * 值传递：会创建副本，所以函数中无法改变原始对象。
     * 引用传递：不会创建副本，所以函数中可以改变原始对象。
     */

    /*
     * 所以，值传递和引用传递的区别并不是传递的内容。而是实参到底有没有被复制一份给形参。
     *
     * Java 中其实还是值传递的，只不过对于对象参数，值的内容是对象的引用。
     *
     * 无论是值传递还是引用传递，其实都是一种求值策略(Evaluation strategy)。在求值策略中，
     * 还有一种叫做按共享传递(call by sharing)。其实Java中的参数传递严格意义上说应该是按
     * 共享传递。
     *
     * 按共享传递，是指在调用函数时，传递给函数的是实参的地址的拷贝（如果实参在栈中，则直接拷
     * 贝该值）。在函数内部对参数进行操作时，需要先拷贝的地址寻找到具体的值，再进行操作。如果
     * 该值在栈中，那么因为是直接拷贝的值，所以函数内部对参数进行操作不会对外部变量产生影响。
     * 如果原来拷贝的是原值在堆中的地址，那么需要先根据该地址找到堆中对应的位置，再进行操作。
     * 因为传递的是地址的拷贝所以函数内对值的操作对外部变量是可见的。
     *
     * 简单点说，Java中的传递，是值传递，而这个值，实际上是对象的引用。而按共享传递其实只是
     * 按值传递的一个特例罢了。所以我们可以说Java的传递是按共享传递，或者说Java中的传递是值
     * 传递。
     */

    public static void main(String[] args) {
        /*
         * PassByValue 类中没有定义构造方法，所以这里使用的是隐式的构造方法来创建对象
         */
        PassByValue obj = new PassByValue();
        /*
         * 情况一：
         */
        int val1 = 1;
        System.out.println("val in main = " + val1);
        obj.passByValue(val1);
        System.out.println("val in main = " + val1);
        System.out.println("---------------------");
        /*
         * 情况二：
         */
        String val2 = "haha";
        System.out.println("val in main = " + val2);
        obj.passByValue(val2);
        System.out.println("val in main = " + val2);
        System.out.println("---------------------");
        /*
         * 情况三：
         */
        Human human = new Human();
        human.name = "小小";
        System.out.println("human.name in main = " + human.name);
        obj.passByValue(human);
        System.out.println("human.name in main = " + human.name);
    }

}
