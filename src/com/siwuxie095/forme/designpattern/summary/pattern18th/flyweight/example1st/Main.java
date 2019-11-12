package com.siwuxie095.forme.designpattern.summary.pattern18th.flyweight.example1st;

/**
 * @author Jiajing Li
 * @date 2019-11-11 17:07:00
 */
class Main {

    /**
     * 享元模式
     *
     * 让某个类的一个实例能用来提供许多 "虚拟实例"。
     *
     *
     * 现在有一个景观设计应用，需要在其中加一些树作为点缀，树有横纵坐标，
     * 表示树的位置。同时还有树龄，以此来展示树的大小。客户将其用在一个
     * 大型规划社区的景观设计，但是过了一个星期之后，客户开始抱怨：在创
     * 建许多树之后，这个程序还是变得呆滞。
     *
     * 可以使用享元模式来解决这个问题。只用一个树的容器来维护 "所有" 树
     * 的状态。
     *
     *
     * 享元的优点：
     * （1）减少运行时对象实例的个数，节省内存。
     * （2）将许多 "虚拟" 对象的状态集中管理。
     *
     * 享元的用途和缺点：
     * （1）当一个类有许多的实例，而这些实例能够被同一方法控制的时候，就
     * 可以使用享元模式。
     * （2）享元模式的缺点在于，一旦你实现了它，那么单个的逻辑实例将无法
     * 拥有独立而不同的行为。
     *
     * PS：享元模式也被称为蝇量模式。
     */
    public static void main(String[] args) {
        TreeManager treeManager = new TreeManager();
        Tree tree1 = treeManager.getTree(1, 1, 20);
        tree1.display();

        Tree tree2 = treeManager.getTree(1, 1, 30);
        tree2.display();

        Tree tree3 = treeManager.getTree(10, 10, 50);
        tree3.display();
    }

}
