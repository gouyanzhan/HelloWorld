package com.siwuxie095.forme.designpattern.category.chapter4th.example1st;

/**
 * @author Jiajing Li
 * @date 2019-10-11 18:16:27
 */
public class Main {

    /**
     * 当看到 "new"，就会想到 "具体"。
     *
     * Pizza pizza = new CheesePizza();
     *
     * 是的，当使用 "new" 时，的确是在实例化一个具体类，所以用的确实是实现，而不是接口。
     * 显然，代码绑着具体类会导致代码更脆弱，更缺乏弹性。
     *
     * 当有一群相关的具体类时，通常会写出如下代码：
     *
     *         if (pizzaType == PizzaType.CHEESE) {
     *             pizza = new CheesePizza();
     *         } else if (pizzaType == PizzaType.GREEK) {
     *             pizza = new GreekPizza();
     *         } else if (pizzaType == PizzaType.PEPPERONI) {
     *             pizza = new PepperoniPizza();
     *         }
     *
     * 有一堆不同的比萨类，但是必须等到运行时，才知道该实例化哪一个。
     *
     * 当看到这样的代码时，一旦有变化或扩展，就必须重新打开这段代码进行检查和修改。
     * 通常这样修改过的代码将造成部分系统更难维护和更新，而且也更容易犯错。
     *
     * 但是，总是要创建对象吧！而 Java 只提供了一个 new 关键字创建对象，不是吗？
     * 还能有些什么？
     *
     * 所以，"new" 有什么不对劲？
     *
     * 在技术上，new 没有错，毕竟这是 Java 的基础部分。真正的犯人是老朋友 "改变"，
     * 以及它是如何影响 new 的使用的。
     * 针对接口编程，可以隔离掉以后系统可能发生的一大堆改变，为什么呢？如果代码是针
     * 对接口而写，那么通过多态，它可以与任何新类实现该接口。但是当代码使用大量的具
     * 体类时，等于是自找麻烦，因为一旦加入新的具体类，就必须改变代码。也就是说，你
     * 的代码并非 "对修改关闭"。想用新的具体类型来扩展代码，必须重新打开它。
     * 所以，应该从OO设计原则去寻找线索，显然第一个原则可以有所帮助：找出会变化的方
     * 面，把它们从不变的部分分离出来。
     *
     *
     * 识别变化的方面：显然，压力是来自于增加更多的比萨类型。
     *
     * 你发现你所有的竞争者都已经在他们的菜单中加入了一些流行风味的比萨：Clam Pizza
     * （蛤蜊比萨）、Veggie Pizza（素食比萨）。很明显，必须要赶上他们，所以也要把
     * 这些风味加进你的菜单中，而最近 Greek Pizza（希腊比萨）卖得不好，所以你决定
     * 将它从菜单中移除。
     *
     * 即 新增或删除某些具体类，将使 orderPizza() 出问题，而且也无法让 orderPizza()
     * 对修改关闭。
     * 但是，现在已经知道哪些会改变，哪些不会改变，该是使用封装的时候了。
     */
    public static void main(String[] args) {

        PizzaStore pizzaStore = new PizzaStore();
        pizzaStore.orderPizza(PizzaType.CHEESE);
        pizzaStore.orderPizza(PizzaType.GREEK);
        pizzaStore.orderPizza(PizzaType.PEPPERONI);
    }

}
