package com.siwuxie095.forme.designpattern.category.chapter8th.example4th;

/**
 * @author Jiajing Li
 * @date 2019-11-05 15:34:32
 */
public class Main {

    /**
     * 模板方法模式
     *
     * 在一个方法中定义一个算法的骨架，而将一些步骤延迟到子类中。模板方法
     * 使得子类可以在不改变算法结构的情况下，重新定义算法中的某些步骤。
     *
     *
     * 这个模式是用来创建一个算法的模板。什么是模板？如你所见的，模板就是
     * 一个方法。更具体的说，这个方法将算法定义成一组步骤，其中的任何步骤
     * 都可以是抽象的，由子类负责实现。这可以确保算法的结构保持不变，同时
     * 由子类提供部分实现。
     */
    public static void main(String[] args) {
        AbstractClass concreteClass1st = new ConcreteClass1st();
        concreteClass1st.templateMethod();

        System.out.println();

        AbstractClass concreteClass2nd = new ConcreteClass2nd();
        concreteClass2nd.templateMethod();
    }

}
