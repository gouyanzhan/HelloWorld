package com.gouyanzhan.clazz;

/**
 * @author Yanzhan Gou
 * @date 2019-03-09 17:19:36
 */
public class HumanTest {
    public static void main(String []args){
        Human wangming = new Human();
        //设定对象的属性值
        wangming.name = "王明";
        wangming.age = 25;
        wangming.sex = "男";
        wangming.addr = "中国北京";
        System.out.println(wangming.name+"晚上23点钟你在干嘛");
        //调用getState()方法，把返回值打印出来
        System.out.println(wangming.getState(23));
        System.out.println("下午15点呢");
        System.out.println(wangming.getState(15));
        wangming.eat();

        Human lisi = new Human();
        lisi = wangming;
        System.out.println("lisi的姓名： "+lisi.name);
        lisi.name = "里斯";
        System.out.println("lisi现在的姓名： "+lisi.name);
        System.out.println("wnagming现在的姓名： " + wangming.name);

    }
}
