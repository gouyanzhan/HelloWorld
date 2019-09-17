package com.gouyanzhan.seven.example8;

/**
 * @author Yanzhan Gou
 * @date 2019-09-17 21:03:40
 */
class Human implements Cloneable {
    String name;
    String sex;
    int age;
    String addr;
    Human(String name,String sex,int age,String addr){
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.addr = addr;
    }
    void work(){
        System.out.println("我在工作");
    }
    void eat(){
        System.out.println("我在吃饭");
    }
    //对象克隆的方法
    public Object clone(){
        Human h = null;
        try{
            h = (Human)super.clone();
        }
        catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return h;
    }

}
