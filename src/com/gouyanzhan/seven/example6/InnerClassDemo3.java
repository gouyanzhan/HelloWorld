package com.gouyanzhan.seven.example6;

/**
 * @author Yanzhan Gou
 * @date 2019-09-17 20:47:21
 */
public class InnerClassDemo3 {
    public static void main(String[] args){
        //创建Outer类的对象
        Outer outer = new Outer();
        outer.print();
        //使用类的内部类
        Outer.Iner1 in1 = new Outer().new Iner1();
        Outer.Iner2 in2 = new Outer.Iner2();
        Outer.Iner1.InClass_In_Iner1 inin2 = new Outer().new Iner1().new InClass_In_Iner1();
        Outer.Iner1.InClass_In_Iner1 inin1 = in1.new InClass_In_Iner1();
        System.out.println(in1);
        System.out.println(in2);
        System.out.println(inin1);
        System.out.println(inin2);
    }

}
