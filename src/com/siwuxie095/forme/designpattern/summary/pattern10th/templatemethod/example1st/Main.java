package com.siwuxie095.forme.designpattern.summary.pattern10th.templatemethod.example1st;

/**
 * @author Jiajing Li
 * @date 2019-11-05 14:19:31
 */
public class Main {

    public static void main(String[] args) {
        CaffeineBeverage coffee = new Coffee();
        coffee.prepareRecipe();

        System.out.println();

        CaffeineBeverage tea = new Tea();
        tea.prepareRecipe();
    }

}
