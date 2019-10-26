package com.siwuxie095.foryou.innerclassdemo.example3;


/**
 * @author Jiajing Li
 * @date 2019-10-08 22:40:11
 */
public class InnerClassDemo {



    public static void main(String[] args) {
        print();
    }

    private static void print() {

        /**
         * the local inner class.
         */
        class LocalInnerClass {

            public LocalInnerClass() {
                init();
            }
            private void init() {
                System.out.println("init");
            }
        }

        new LocalInnerClass();
    }

}
