package com.siwuxie095.forme.designpattern.summary.pattern4th.factorymethod.example2nd;

/**
 * @author Jiajing Li
 * @date 2019-10-12 17:53:55
 */
public class Main {

    public static void main(String[] args) {
        Creator creator = new ConcreteCreator1st();
        creator.anOperation("undefined");
    }

}
