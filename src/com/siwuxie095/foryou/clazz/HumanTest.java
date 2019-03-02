package com.siwuxie095.foryou.clazz;

/**
 * @author Jiajing Li
 * @date 2019-01-20 22:24:52
 */
public class HumanTest {

    public static void main(String[] args) {
        Human woman = new Human();
        woman.name = "小红";
        woman.age = 18;
        woman.sex = "女";
        woman.selfIntroduce();
        woman.work();
        woman.eat();

        System.out.println();
        System.out.println(woman.getState(0));
        System.out.println(woman.getState(8));
        System.out.println(woman.getState(17));

        System.out.println("---------------");

        Human man = new Human();
        man.name = "小蓝";
        man.age = 20;
        man.sex = "男";
        man.selfIntroduce();
        man.work();
        man.eat();
        man.name = "小绿";
        man.selfIntroduce();
        int a = 1;
        System.out.println(a);
        a = 2;
        System.out.println(a);

    }

}
