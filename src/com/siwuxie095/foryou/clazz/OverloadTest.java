package com.siwuxie095.foryou.clazz;

/**
 * @author Jiajing Li
 * @date 2019-01-21 22:43:26
 */
public class OverloadTest {

    public static void main(String[] args) {
        Overload overload = new Overload();
        overload.testOverload();
        overload.testOverload(1);
        overload.testOverload(2D);
        overload.testOverload("咦");
        Overload overload1 = new Overload();
        overload1.printThing();
        System.out.println("ee");
        int c = 1;
        overload1.printInt(c);
        double b = 2.0;
        overload1.printDouble(b);
        String a = "gyz";
        overload1.printString(a);
        System.out.println("--------------");
        overload1.print();
        overload1.print(c);
        overload1.print(b);
        overload1.print(a);
    }


}
