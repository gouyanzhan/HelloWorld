package com.siwuxie095.forme.designpattern.category.chapter3rd.example5th;

/**
 * @author Jiajing Li
 * @date 2019-10-10 13:48:40
 */
public class Main {

    /**
     * 星巴兹决定开始在菜单上加上饮料的容量，供顾客选择：小杯 tall、中杯 grande、大杯 venti。
     * 所以需要在 Beverage 类中加入 size 相关的代码。
     *
     * 同时，调料会根据饮料容量的大小来加收费用。所以需要在 Condiment 类中加入 getCostBySize()
     * 方法。
     * （PS：按理说，每种调料加收的费用都不同，所以应该在具体的调料中实现不同的 getCostBySize() 方法，
     * 但这里偷了下懒，直接一刀切了）
     *
     * 另外，加了一个新的具体装饰者 CondimentPrettyPrint，用于调料的美化打印。只需在选好饮料与
     * 调料后，再用它包装一下即可。
     */
    public static void main(String[] args) {

            Beverage houseBlend = new HouseBlend();
            System.out.println(houseBlend.getDescription() + " $" + houseBlend.cost());

            houseBlend = new Mocha(houseBlend);
            System.out.println(houseBlend.getDescription() + " $" + houseBlend.cost());

            houseBlend = new Mocha(houseBlend);
            System.out.println(houseBlend.getDescription() + " $" + houseBlend.cost());

            houseBlend = new Whip(houseBlend);
            System.out.println(houseBlend.getDescription() + " $" + houseBlend.cost());

            houseBlend = new Mocha(houseBlend);
            System.out.println(houseBlend.getDescription() + " $" + houseBlend.cost());


            houseBlend = new CondimentPrettyPrint(houseBlend);
            System.out.println(houseBlend.getDescription() + " $" + houseBlend.cost());
    }

}
