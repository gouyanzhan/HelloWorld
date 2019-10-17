package com.siwuxie095.foryou.innerclassdemo.example1;

/**
 * the outer class.
 *
 * @author Jiajing Li
 * @date 2019-09-16 23:21:54
 */
class Outer {

    private String outerString = "String in Outer";

    void printOuter() {
        Inner inner = new Inner();
        System.out.println("Outer#printOuter:");
        System.out.println(inner.innerString);
        inner.printInner();
    }

    /**
     * the inner class which is non-static.
     */
    class Inner {

        private String innerString = "String in Inner";

        void printInner() {
            System.out.println("Inner#printInner:");
            System.out.println("use\"" + outerString + "\"");
        }

        void printInnter0() {
            System.out.println("Inner#printInner0:");
            printOuter();
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
        Outer.Inner inner = new Outer().new Inner();
        inner.printInner();

        System.out.println();
        inner.printInnter0();
    }

}
