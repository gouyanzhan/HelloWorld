package com.siwuxie095.forme.designpattern.category.chapter14th.example12th;

/**
 * @author Jiajing Li
 * @date 2019-11-11 21:27:32
 */
public class Main {

    /**
     * 中介者模式
     */
    public static void main(String[] args) {
        Colleague colleague1 = new ConcreteColleague1st();
        Colleague colleague2 = new ConcreteColleague2nd();
        Mediator mediator = new ConcreteMediator();
        mediator.register(colleague1);
        mediator.register(colleague2);

        colleague1.send();
        colleague2.send();
    }

}
