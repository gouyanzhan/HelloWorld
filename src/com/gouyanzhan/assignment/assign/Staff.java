package com.gouyanzhan.assignment.assign;

/**
 * @author Yanzhan Gou
 * @date 2019-05-18 12:47:14
 */
public class Staff {
    private String name;
    private int age;
    private String number;
    private int wage;

    public Staff(){

    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return this.age;
    }
    public void setNumber(String number){
        this.number = number;
    }
    public String getNumber(){
        return this.number;
    }
    public void setWage(int wage){
        this.wage = wage;
    }
    public int getWage(){
        return this.wage;
    }

}

//3.定义一个员工类,自己分析出几个成员，然后给出成员变量，构造方法， getXxx()/setXxx()方法，以及一个显示所有成员信息的方法。并测试