package com.gouyanzhan.seven.example8;

/**
 * @author Yanzhan Gou
 * @date 2019-09-17 21:09:11
 */
public class CloneDemo {
    public static void main(String[] args){
        Human zhangsan = new Human("张三","男", 23,"北京");
        Human lisi = (Human)zhangsan.clone();
        lisi.name = "李四";
        System.out.println("把李四的名字改为李四");
        System.out.println("李四的名字：" + lisi.name);
        System.out.println("张三的名字：" + zhangsan.name);
    }

}
