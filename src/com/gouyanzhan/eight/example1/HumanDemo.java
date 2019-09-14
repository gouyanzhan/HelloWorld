package com.gouyanzhan.eight.example1;

/**
 * @author Yanzhan Gou
 * @date 2019-08-02 15:54:08
 */
public class HumanDemo {
    public static void main(String[] args){
        Human gouyanzhan = new Human();
        //设置成员变量的值
        gouyanzhan.setName("缑延展");
        gouyanzhan.setAge(18);
        gouyanzhan.setSex("女");
        gouyanzhan.setAddr("中国");
        System.out.println("缑延展的个人信息如下：");
        //打印出对象的信息，用get方法获得属性值
        System.out.println("姓名：" + gouyanzhan.getName());
        System.out.println("性别：" + gouyanzhan.getSex());
        System.out.println("年龄：" + gouyanzhan.getAge());
        System.out.println("地址：" + gouyanzhan.getAddr());

    }



}
