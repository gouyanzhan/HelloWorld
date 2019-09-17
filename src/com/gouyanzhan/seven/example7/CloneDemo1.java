package com.gouyanzhan.seven.example7;

/**
 * @author Yanzhan Gou
 * @date 2019-09-17 20:58:26
 */
public class CloneDemo1 {
    public static void main(String[] args){
        Human zhangsan = new Human("张三","男",23,"北京");
        System.out.println("张三的名字：" + zhangsan.name);
        //对象的赋值
        Human lisi = zhangsan;
        lisi.name = "李四";
        //打印出更改之后的结果
        System.out.println("把李四的名字改为李四");
        System.out.println("李四的名字：" + lisi.name);
        System.out.println("张三的名字：" + zhangsan.name);
    }

}
