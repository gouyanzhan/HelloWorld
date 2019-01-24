package com.siwuxie095.forme.algorithm.chapter1st.question4th.answer1st;

/**
 * 猫狗队列
 *
 * 题目：
 * 有宠物 Pet、猫 Cat、狗 Dog 类，实现一种猫狗队列的结构，要求如下：
 * 1、可以调用 add 方法，将 Cat 类或 Dog 类的实例放入队列中
 * 2、可以调用 pollAll 方法，将队列中所有实例按进队列的先后顺序依次弹出
 * 3、可以调用 pollCat 方法，将 Cat 类的实例按进队列的先后顺序依次弹出
 * 4、可以调用 pollDog 方法，将 Dog 类的实例按进队列的先后顺序依次弹出
 * 5、可以调用 isEmpty 方法，检查队列中是否还有 Cat 类或 Dog 类的实例
 * 6、可以调用 isCatEmpty 方法，检查队列中是否还有 Cat 类的实例
 * 7、可以调用 isDogEmpty 方法，检查队列中是否还有 Dog 类的实例
 *
 * 解答：
 * 将不同实例盖上时间戳，但又不改变原有的类，所以要定义一个新的类 PetEnterQueue，
 * 队列中真正存入的正是 PetEnterQueue 的实例。
 *
 * 大体说来，首先要有一个不断累加的数据项来表示实例进队列的时间，同时有两个队列，
 * 一个是只放 Cat 类实例的队列 catQ，另一个是只放 Dog 类实例的队列 dogQ
 *
 * 注意：从外部来看，依然是「一个」队列
 *
 * @author Jiajing Li
 * @date 2019-01-18 16:24:10
 */
public class Main {

    public static void main(String[] args) {

        CatDogQueue catDogQueue = initCatDogQueue();

        while (!catDogQueue.isEmpty()) {
            System.out.println(catDogQueue.pollAll());
        }
        System.out.println("-----------------------");

        catDogQueue = initCatDogQueue();
        while (!catDogQueue.isCatQueueEmpty()) {
            System.out.println(catDogQueue.pollCat());
        }
        System.out.println("-----------------------");

        catDogQueue = initCatDogQueue();
        while (!catDogQueue.isDogQueueEmpty()) {
            System.out.println(catDogQueue.pollDog());
        }
        System.out.println("-----------------------");

    }

    public static CatDogQueue initCatDogQueue() {
        CatDogQueue catDogQueue = new CatDogQueue();
        Cat cat1 = new Cat();
        Cat cat2 = new Cat();
        Cat cat3 = new Cat();

        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        Dog dog3 = new Dog();
        Dog dog4 = new Dog();
        Dog dog5 = new Dog();

        catDogQueue.add(cat1);
        catDogQueue.add(cat2);

        catDogQueue.add(dog1);
        catDogQueue.add(dog2);
        catDogQueue.add(dog3);

        catDogQueue.add(cat3);

        catDogQueue.add(dog4);
        catDogQueue.add(dog5);

        return catDogQueue;
    }

}
