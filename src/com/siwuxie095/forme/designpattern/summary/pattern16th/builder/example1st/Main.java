package com.siwuxie095.forme.designpattern.summary.pattern16th.builder.example1st;

/**
 * @author Jiajing Li
 * @date 2019-11-11 15:36:57
 */
public class Main {

    public static void main(String[] args) {
        AbstractBuilder builder = new ConcreteBuilder();
        Client client = new Client(builder);
        VacationPlanner planner = client.constructVacationPlanner();
        System.out.println(planner);
    }

}
