package com.gouyanzhan.eight.example1;

/**
 * @author Yanzhan Gou
 * @date 2019-08-02 15:36:44
 */
 class Human {
    //成员属性都是私有的
    private String name;
    private String sex;
    private int age;
    private String addr;
    //public的设置和访问方法
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getSex(){
        return sex;
    }
    public void setSex(String sex){
        this.sex = sex;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    public String getAddr(){
        return addr;
    }
    public void  setAddr(String addr){
        this.addr = addr;
    }
    public void work(){
        System.out.println("我在工作");
    }
    public void eat(){
        System.out.println("我在吃饭");
    }
}

