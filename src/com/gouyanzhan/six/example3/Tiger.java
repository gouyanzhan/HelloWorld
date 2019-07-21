package com.gouyanzhan.six.example3;

/**
 * @author Yanzhan Gou
 * @date 2019-07-21 15:54:35
 */ //Tiger类继承Animal类
class Tiger extends Animal {
    String tigerType;
    String from;

    //Tiger自己的方法
    void tigerRun() {
        System.out.println("老虎在奔跑");
    }

    @Override   //方法覆写
    void breath() {
        //通过super关键字调用父类的breath方法
        super.breath();  //调用动物类的呼吸方法
        System.out.println("老虎是用肺呼吸的");
    }
}
