package com.siwuxie095.forme.designpattern.summary.pattern5th.abstractfactory.example1st;

/**
 * 比萨
 *
 * @author Jiajing Li
 * @date 2019-10-14 14:20:07
 */
class Pizza {

    /**
     * 比萨名称
     */
    String name;

    /**
     * 面团类型（原料）
     */
    Dough dough;

    /**
     * 酱料类型（原料）
     */
    Sauce sauce;

    /**
     * 一套佐料（原料）
     */
    Topping toppings[];

    /**
     * 原料工厂
     */
    PizzaIngredientFactory ingredientFactory;

    public Pizza(PizzaIngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }

    /**
     * 准备（通过原料工厂来收集比萨所需的原料）
     */
    void prepare() {
        this.name = "Pizza";
        this.dough = ingredientFactory.createDough();
        this.sauce = ingredientFactory.createSauce();
        this.toppings = ingredientFactory.createToppings();
        printPrepare();
    }

    /**
     * 打印准备的原料
     */
    void printPrepare() {
        System.out.println("Preparing: " + name);
        System.out.println("Tossing dough: " + dough);
        System.out.println("Adding sauce: " + sauce);
        System.out.print("Adding toppings: ");
        for (Topping topping : toppings) {
            System.out.print(topping + "  ");
        }
        System.out.println();
    }

    /**
     * 烘烤
     */
    void bake() {
        System.out.println("Bake 25 minutes at 350 °C");
    }

    /**
     * 切片
     */
    void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    /**
     * 装盒
     */
    void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }

    public String getName() {
        return name;
    }
}
