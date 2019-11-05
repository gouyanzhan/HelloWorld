package com.siwuxie095.forme.designpattern.summary.pattern10th.templatemethod.example3rd;

/**
 * @author Jiajing Li
 * @date 2019-11-05 14:19:31
 */
public class Main {

    public static void main(String[] args) {
        CaffeineBeverageWithHook coffee = new CoffeeWithHook();
        coffee.prepareRecipe();

        System.out.println();

        CaffeineBeverageWithHook tea = new Tea();
        tea.prepareRecipe();
    }

}
