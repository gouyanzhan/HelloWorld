package com.siwuxie095.forme.designpattern.category.chapter14th.example15th;

/**
 * @author Jiajing Li
 * @date 2019-11-11 22:13:12
 */
public class Main {

    /**
     * 原型模式
     *
     * 解决创建给定类的实例的过程很昂贵或很复杂的问题。
     *
     *
     * 现在有一个游戏，你希望怪兽能随着场景变化而演化，而不是一直一成不变。
     * 但创建各种各样的怪兽实例已经变得越来越麻烦...
     *
     * 可以使用原型模式。原型模式允许你通过复制现有的实例来创建新的实例。在
     * Java 中，这通常意味着使用 clone() 方法或者反序列化。这个模式的重点
     * 在于，客户的代码在不知道要实例化何种特定类的情况下，可以制造出新的实
     * 例。
     *
     *
     * 原型的优点：
     * （1）向客户隐藏制造新实例的复杂性。
     * （2）提供让客户能够产生未知类型对象的选项。
     * （3）在某些环境下，复制对象比创建新对象更有效。
     *
     * 原型的用途和缺点：
     * （1）在一个复杂的类层次中，当系统必须从其中的许多类型创建新对象时，
     * 可以考虑原型。
     * （2）使用原型模式的缺点：对象的复制有时相当复杂。
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        MonsterMaker monsterMaker = new MonsterMaker();
        Monster monster = monsterMaker.makeRandomMonster();
        System.out.println(monster.getClass().getSimpleName());
    }

}
