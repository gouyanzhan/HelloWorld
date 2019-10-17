package com.siwuxie095.forme.designpattern.summary.pattern5th.abstractfactory.example2nd;

/**
 * @author Jiajing Li
 * @date 2019-10-14 17:42:12
 */
public class Main {

    public static void main(String[] args) {
        AbstractFactory factory = new ConcreteFactory1st();
        Client client = new Client(factory);
    }

}
