package com.siwuxie095.foryou.innerclassdemo.example2;

/**
 * the outer class.
 *
 * @author Jiajing Li
 * @date 2019-10-08 22:24:41
 */
class Outer {

    private String outerString = "String in Outer";

    static String staticOuterString = "Static String in Outer";

    void printOuter() {
        System.out.println("Outer#printOuter:");
        Inner inner = new Inner();
        inner.printInner();
    }

    /**
     * the inner class which is static.
     */
    public static class Inner {

        private String innerString = "String in Inner";

        private static String staticS = "l;";

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

