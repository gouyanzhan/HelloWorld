package com.siwuxie095.forme.designpattern.summary.pattern4th.factorymethod.example1st;

import java.util.ArrayList;
import java.util.List;

/**
 * 比萨
 *
 * @author Jiajing Li
 * @date 2019-10-12 10:35:52
 */
abstract class Pizza {

    /**
     * 比萨名称
     */
    String name;

    /**
     * 面团类型
     */
    String dough;

    /**
     * 酱料类型
     */
    String sauce;

    /**
     * 一套佐料
     */
    List<String> toppings = new ArrayList<>();


    /**
     * 准备
     */
    void prepare() {
        System.out.println("Preparing: " + name);
        System.out.println("Tossing dough: " + dough);
        System.out.println("Adding sauce: " + sauce);
        System.out.print("Adding toppings: ");
        for (String topping : toppings) {
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
