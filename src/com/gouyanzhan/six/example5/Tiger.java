package com.gouyanzhan.six.example5;

/**
 * @author Yanzhan Gou
 * @date 2019-07-21 16:47:10
 */ //Tiger继承抽象类Animal
class Tiger extends Animal{
    String tigerType;
    String from;
    void tigerRun(){
        System.out.println("老虎在奔跑");
    }
    @Override
    void breath(){
        System.out.println("老虎是用肺部呼吸的");
    }
}
