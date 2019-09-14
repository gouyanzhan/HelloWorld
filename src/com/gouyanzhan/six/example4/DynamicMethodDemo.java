package com.gouyanzhan.six.example4;

public class DynamicMethodDemo {
    /**
     *多态分为两种，第一种是重载，是静态绑定（编译期绑定），也叫早绑定；
     * 第二种是重写（覆写），是动态绑定（运行期绑定），也叫晚绑定
     */
    public static void main(String[] args){
        Animal[] animal = new Animal[3];
        //创建不同的对象，但是都存入Animal的引用中
        animal[0] = new Animal();
        animal[1] = new Tiger();
        animal[2] = new Fish();
        animal[1].breath();
        System.out.println();
        animal[2].breath();
    }
}
