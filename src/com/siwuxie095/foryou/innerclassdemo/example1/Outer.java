package com.siwuxie095.foryou.innerclassdemo.example1;

/**
 * the outer class.
 *
 * @author Yanzhan Gou
 * @date 2019-10-26 14:39:04
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

        //private static String staticS = "l;";

        void printInner() {
            System.out.println("Inner#printInner:");
            System.out.println("use\"" + outerString + "\"");
        }

        void printInner0() {
            System.out.println("Inner#printInner0:");
            printOuter();
        }

        /**
         * the inner class in inner class
         */
        class X {

        }

    }

}

