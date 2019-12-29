package com.siwuxie095.forme.designpattern.summary.pattern11th.iterator.example3rd;

/**
 * 客户
 *
 * @author Jiajing Li
 * @date 2019-11-06 16:44:33
 */
public class Client {

    private Aggregate aggregate;

    Client(Aggregate aggregate) {
        this.aggregate = aggregate;
    }

    void doSomething() {
        Iterator iterator = aggregate.createIterator();
    }

    private void doSomething(Iterator iterator) {
        while (iterator.hasNext()) {
            // do something ...
            String element = (String) iterator.next();
            System.out.println(element);
        }
    }
}
