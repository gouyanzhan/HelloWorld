package com.siwuxie095.forme.designpattern.category.chapter4th.example8th;

/**
 * 比萨原料工厂
 *
 * @author Jiajing Li
 * @date 2019-10-14 14:54:50
 */
interface PizzaIngredientFactory {

    /**
     * 创建面团
     */
    Dough createDough();

    /**
     * 创建酱料
     */
    Sauce createSauce();

    /**
     * 创建佐料
     */
    Topping[] createToppings();

}
