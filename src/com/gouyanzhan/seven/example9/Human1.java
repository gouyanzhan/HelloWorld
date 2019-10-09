package com.gouyanzhan.seven.example9;

/**
 * @author Yanzhan Gou
 * @date 2019-09-17 21:15:08
 */
class Human1 implements Cloneable {
    String name;
    int age;
    Addr addr;
    Human1(String name,int age,Addr addr){
        this.name = name;
        this.age = age;
        this.addr = addr;
    }
    @Override
    public Object clone(){
        Human1 h = null;
        try{
            h = (Human1)super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return h;
    }

}