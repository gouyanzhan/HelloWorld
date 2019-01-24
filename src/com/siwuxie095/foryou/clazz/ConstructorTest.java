package com.siwuxie095.foryou.clazz;

/**
 * @author Jiajing Li
 * @date 2019-01-22 15:42:40
 */
public class ConstructorTest {

    public static void main(String[] args) {
        Constructor con1 = new Constructor();
        con1.print();
        Constructor con2 = new Constructor("小红");
        con2.print();
        Constructor con3 = new Constructor("小黄", 12);
        con3.print();
        Constructor con4 = new Constructor("小蓝", 18, "男");
        con4.print();
        Constructor con5 = new Constructor("小紫", 22, "女", "买买买");
        con5.print();
    }

}
