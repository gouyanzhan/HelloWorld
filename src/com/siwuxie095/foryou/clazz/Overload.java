package com.siwuxie095.foryou.clazz;

/**
 * 关于方法重载
 *
 * @author Jiajing Li
 * @date 2019-01-21 22:36:33
 */
public class Overload {

    public void testOverload() {
        System.out.println("无参");
    }

    /**
     * 这个重载方法注释掉与不注释掉的区别
     */
    public void testOverload(int val) {
        System.out.println("int - " + val);
    }

    public void testOverload(double val) {
        System.out.println("double - " + val);
    }

    public void testOverload(String val) {
        System.out.println("String - " + val);
    }

    public void printThing(){
        System.out.println("hhhhh");
    }

    public void printInt(int a){
        System.out.println(a);
    }

    public void printDouble(double b){
        System.out.println(b);
    }

    public void printString(String c){
        System.out.println(c);
    }

    public void print(){
        System.out.println("hhhhh");
    }

    public void print(int a){
        System.out.println(a);
    }

    public void print(double b){
        System.out.println(b);
    }

    public void print(String c){
        System.out.println(c);
    }
}
