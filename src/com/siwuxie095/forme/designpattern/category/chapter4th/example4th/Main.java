package com.siwuxie095.forme.designpattern.category.chapter4th.example4th;

/**
 * @author Jiajing Li
 * @date 2019-10-12 15:19:29
 */
public class Main {

    /**
     * 给比萨店使用的框架
     *
     * 有个做法可让比萨制作活动局限于 PizzaStore 类，而同时又能让这些加盟店
     * 依然可以自由地制作该区域对应风味的比萨。
     *
     * 所要做的事情就是把 createPizza() 方法放回到 PizzaStore 中，不过要
     * 把它设置成 "抽象方法"，然后为每个区域风味创建一个 PizzaStore 的子类。
     *
     * 有了 PizzaStore 作为超类之后，让每个区域的比萨店（NewYorkPizzaStore、
     * ChicagoPizzaStore、CaliforniaPizzaStore）都继承它，每个子类各自
     * 决定如何制造比萨。
     *
     * 现在 PizzaStore 已经有了一个不错的订单系统，由 orderPizza() 方法
     * 负责处理订单，而你希望所有加盟店对于订单的处理都能一致。
     * 各个区域比萨店的差异在于他们制作的比萨风味，现在让 createPizza()
     * 方法来负责创建正确种类的比萨。做法是让各个子类负责定义自己的 createPizza()
     * 方法，每个子类都有自己的比萨变体，而仍然符合 PizzaStore 框架，并使
     * 用调试好的 orderPizza() 方法。
     *
     *
     * 关于子类做决定的疑问：
     *
     * 问：
     * 毕竟 PizzaStore 的子类终究只是子类，如何能做决定？比如，NewYorkPizzaStore
     * 类中，并没有看到任何做决定逻辑的代码。
     * 答：
     * 这要从 PizzaStore 的 orderPizza() 方法来看，它是在抽象的 PizzaStore
     * 中定义，但是只在子类中实现具体类型。
     * 而 orderPizza() 方法对 Pizza 对象做了许多事情（如：准备、烘烤、切片、装
     * 盒），但是由于 Pizza 对象是抽象的，orderPizza() 并不知道哪些具体类参与进
     * 来了。换句话说，这就是解耦（decouple）。
     * 即 orderPizza() 方法在抽象类中定义，而不是在子类中定义，所以此方法并不知道
     * 哪个子类将实际上制作比萨。
     * 当 orderPizza() 调用 createPizza() 时，某个比萨店子类将负责创建比萨。具
     * 体做哪一种比萨，正是由具体的比萨店来决定。
     *
     * 问：
     * 那么，子类是实时做出这样的决定吗？
     * 答：
     * 不是，但是从 orderPizza() 的角度来看，如果选择在 NewYorkPizzaStore
     * 订购比萨，就是由这个子类（NewYorkPizzaStore）决定。严格来说，并非是由
     * 这个子类实际做 "决定"，而是由 "顾客" 决定到哪一家风味的比萨店才决定了比
     * 萨的风味。
     */
    public static void main(String[] args) {
        PizzaStore newYorkPizzaStore = new NewYorkPizzaStore();
        newYorkPizzaStore.orderPizza(PizzaType.CHEESE);

        PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
        chicagoPizzaStore.orderPizza(PizzaType.PEPPERONI);

        PizzaStore californiaPizzaStore = new CaliforniaPizzaStore();
        californiaPizzaStore.orderPizza(PizzaType.VEGGIE);
    }

}
