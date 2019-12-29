package com.siwuxie095.forme.designpattern.summary.pattern10th.templatemethod.example2nd;

/**
 * @author Jiajing Li
 * @date 2019-11-05 15:34:32
 */
public class Main {

    public static void main(String[] args) {
        AbstractClass concreteClass1st = new ConcreteClass1st();
        concreteClass1st.templateMethod();

        System.out.println();

        AbstractClass concreteClass2nd = new ConcreteClass2nd();
        concreteClass2nd.templateMethod();
    }

}
