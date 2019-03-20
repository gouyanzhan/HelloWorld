package com.siwuxie095.foryou.extend;

/**
 * @author Jiajing Li
 * @date 2019-03-18 09:18:39
 */
public class DerivedClass extends BaseClass {

    public DerivedClass() {
        System.out.println("DerivedClass 的无参构造方法");
    }

    public DerivedClass(int val) {
        // 注释掉这一行的区别
        //super();
        System.out.println("DerivedClass 的有参构造方法 - " + val);
    }

    public DerivedClass(String val) {
        // 注释掉这一行的区别
        //super(val);
        System.out.println("DerivedClass 的有参构造方法 - " + val);
    }

}
