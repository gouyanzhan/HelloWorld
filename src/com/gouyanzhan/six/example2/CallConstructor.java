package com.gouyanzhan.six.example2;

/**
 * @author Yanzhan Gou
 * @date 2019-07-21 14:32:14
 */
class A{
    A(){
        System.out.println("调用A的构造函数");
    }
}
//类B继承A
class B extends A{
    B(){
        System.out.println("调用B的构造函数");
    }
}
//类C继承B
class C extends B{
    C(){
        System.out.println("调用C的构造函数");
    }
}
//通过该类掩饰对象的构造过程
public class CallConstructor {
    public static void main(String[] args){
        C c = new C();
    }
    

}
