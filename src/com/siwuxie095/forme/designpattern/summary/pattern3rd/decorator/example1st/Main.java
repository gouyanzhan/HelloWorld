package com.siwuxie095.forme.designpattern.summary.pattern3rd.decorator.example1st;

/**
 * @author Jiajing Li
 * @date 2019-10-10 13:48:40
 */
public class Main {

    public static void main(String[] args) throws Exception {

            Beverage houseBlend = new HouseBlend();
            System.out.println(houseBlend.getDescription() + " $" + houseBlend.cost());

            houseBlend.setSize(Beverage.VENTI);

            houseBlend = new Mocha(houseBlend);
            System.out.println(houseBlend.getDescription() + " $" + houseBlend.cost());

            houseBlend = new Mocha(houseBlend);
            System.out.println(houseBlend.getDescription() + " $" + houseBlend.cost());

            houseBlend = new Whip(houseBlend);
            System.out.println(houseBlend.getDescription() + " $" + houseBlend.cost());

            houseBlend = new Mocha(houseBlend);
            System.out.println(houseBlend.getDescription() + " $" + houseBlend.cost());

            System.out.println();

            houseBlend = new CondimentPrettyPrint(houseBlend);
            System.out.println(houseBlend.getDescription() + " $" + houseBlend.cost());
    }

}
