package com.siwuxie095.foryou.innerclassdemo.example2;

import java.util.Objects;

/**
 * the outer class.
 *
 * @author Jiajing Li
 * @date 2019-10-08 22:24:41
 */
class Outer {

    private String outerString = "String in Outer";

    void printOuter() {
        System.out.println("Outer#printOuter:");
        Inner inner = new Inner();
        inner.printInner();
    }

    /**
     * the inner class which is static.
     */
    static class Inner {

        private String innerString = "String in Inner";

        void printInner() {
            System.out.println("Inner#printInner:");
            Outer outer = new Outer();
            System.out.println("use\"" + outer.outerString + "\"");
        }

        void printInner0() {
            System.out.println("Inner#printInner0:");
            Outer outer = new Outer();
            outer.printOuter();
        }
    }

}


/**
 * the demo class.
 */
public class InnerClassDemo {

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.printOuter();

        System.out.println();
        Outer.Inner inner = new Outer.Inner();
        inner.printInner();

        System.out.println();
        inner.printInner0();
    }

}
