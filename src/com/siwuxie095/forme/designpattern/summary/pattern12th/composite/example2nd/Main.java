package com.siwuxie095.forme.designpattern.summary.pattern12th.composite.example2nd;

/**
 * @author Jiajing Li
 * @date 2019-11-06 23:48:31
 */
public class Main {

    public static void main(String[] args) {
        Component allComponents = new Composite();

        Component compositeA = new Composite();
        Component compositeB = new Composite();
        Component compositeC = new Composite();

        allComponents.add(compositeA);
        allComponents.add(compositeB);
        allComponents.add(compositeC);

        Component leafA1st = new Leaf();
        Component leafA2nd = new Leaf();
        Component leafA3rd = new Leaf();

        compositeA.add(leafA1st);
        compositeA.add(leafA2nd);
        compositeA.add(leafA3rd);

        Client client = new Client(allComponents);
        client.doSomething();
    }

}
