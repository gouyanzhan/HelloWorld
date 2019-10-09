package com.gouyanzhan.seven.example2;

/**
 * @author Yanzhan Gou
 * @date 2019-09-15 19:28:45
 */
public class AnimalDemo {
    public static void main(String[] args){
        //Animal接口，Fish对象
        Animal fish = new Fish("大鲨鱼");
        //Animal 接口，Tiger对象
        Animal tiger1 = new Tiger("东北虎");
        //Mammal接口，Tiger对象
        Mammal tiger2 = new Tiger("华南虎");
        //使用fish调用各种方法
        fish.breath();
        fish.eat();
        fish.sleep();
        //使用tiger调用各种方法
        tiger1.breath();
        tiger1.eat();
        tiger1.sleep();
        //调用run方法，需要进行类型转换
        ((Tiger)tiger1).run();
        //使用tiger2调用各种方法
        tiger2.breath();
        tiger2.eat();
        tiger2.sleep();
        tiger2.run();
    }

}
