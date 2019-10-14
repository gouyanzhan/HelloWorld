package com.siwuxie095.forme.designpattern.category.chapter4th.example1st;

/**
 * 比萨店
 *
 * @author Jiajing Li
 * @date 2019-10-11 17:53:02
 */
class PizzaStore {

    Pizza orderPizza(PizzaType pizzaType) {
        Pizza pizza = null;

        /*
         * 这里是变化的部分。随着时间推移，比萨菜单改变，这里
         * 就必须一改再改。
         *
         */
        if (pizzaType == PizzaType.CHEESE) {
            pizza = new CheesePizza();
        } else if (pizzaType == PizzaType.GREEK) {
            pizza = new GreekPizza();
        } else if (pizzaType == PizzaType.PEPPERONI) {
            pizza = new PepperoniPizza();
        }

        /*
         * 有了比萨之后，就开始准备、烘烤、切片、装盒。
         *
         * 这里是不想改变的部分。因为比萨的准备、烘烤等操作多年
         * 来都持续不变。
         * 所以这部分代码不会改变，只有发生这些动作的比萨会改变。
         *
         */
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

}
