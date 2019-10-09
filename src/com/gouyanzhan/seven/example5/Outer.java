package com.gouyanzhan.seven.example5;

/**
 * @author Yanzhan Gou
 * @date 2019-09-16 22:26:46
 */
class Outer {
    String out_string = "String in Outer";
    void useIner1(){
        Iner1 in1 = new Iner1();
        in1.print();
    }
    void useIner2(){
        Iner2 in2 = new Iner2();
        in2.print();
    }

    //非静态内部类
    class Iner1{
        void print(){
            System.out.println("Iner1.print()");
            //可以直接使用宿主类的变量
            System.out.println("Outer.out_string=" + out_string + "");
        }
    }
    //静态内部类
    static class Iner2{
        void print(){
            System.out.println("Iner2.print()");
            //System.out.println("Outer.out_string =" + out_string + "");
            //需要使用对象来方法宿主类的变量
            Outer outer = new Outer();
            System.out.println("Outer.out_string=" + outer.out_string);
        }
    }
}
