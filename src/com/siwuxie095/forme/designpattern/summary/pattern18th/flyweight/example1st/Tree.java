package com.siwuxie095.forme.designpattern.summary.pattern18th.flyweight.example1st;

/**
 * 树
 *
 * @author Jiajing Li
 * @date 2019-11-11 17:13:40
 */
class Tree {

    /**
     * 横坐标
     */
    private int x;

    /**
     * 纵坐标
     */
    private int y;

    /**
     * 树龄
     */
    private int age;

    Tree(int x, int y, int age) {
        this.x = x;
        this.y = y;
        this.age = age;
    }

    void display() {
        System.out.println("------------");
        System.out.println("当前树的信息：");
        System.out.println("横坐标：" + x);
        System.out.println("纵坐标：" + y);
        System.out.println("树龄：" + age);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
