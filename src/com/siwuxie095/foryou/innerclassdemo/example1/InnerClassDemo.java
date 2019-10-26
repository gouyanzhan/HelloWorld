package com.siwuxie095.foryou.innerclassdemo.example1;

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
        inner.printInner0();
    }

}
