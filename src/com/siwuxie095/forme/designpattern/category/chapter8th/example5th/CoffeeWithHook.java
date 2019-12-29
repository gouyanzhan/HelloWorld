package com.siwuxie095.forme.designpattern.category.chapter8th.example5th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 咖啡
 *
 * @author Jiajing Li
 * @date 2019-11-05 13:49:15
 */
class CoffeeWithHook extends CaffeineBeverageWithHook {

    /**
     * 用沸水冲泡咖啡
     */
    @Override
    void brew() {
        System.out.println("Dripping coffee through filter");
    }

    /**
     * 加糖和牛奶
     */
    @Override
    void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }

    /**
     * 覆盖钩子方法，提供自己的功能。
     *
     * 让用户输入他们对调料的决定。根据用户输入返回 true 或 false。
     */
    @Override
    boolean customerWantsCondiments() {
        String answer = getUserInput();

        return answer.toLowerCase().startsWith("y");
    }

    /**
     * 获取用户输入
     */
    private String getUserInput() {
        String answer = null;

        System.out.println("Would you like milk and sugar with your coffee (y/n) ?");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        try {
            answer = in.readLine();
        } catch (IOException e) {
            System.err.println("IO error trying to read your answer");
            e.printStackTrace();
        }
        if (null == answer) {
            return "no";
        }
        return answer;
    }
}
