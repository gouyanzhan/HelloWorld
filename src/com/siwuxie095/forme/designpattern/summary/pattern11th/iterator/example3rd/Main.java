package com.siwuxie095.forme.designpattern.summary.pattern11th.iterator.example3rd;

/**
 * @author Jiajing Li
 * @date 2019-11-06 16:48:00
 */
public class Main {

    public static void main(String[] args) {
        Aggregate aggregate = new ConcreteAggregate();
        Client client = new Client(aggregate);
        client.doSomething();
    }

}
