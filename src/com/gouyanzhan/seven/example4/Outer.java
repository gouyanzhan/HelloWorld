package com.gouyanzhan.seven.example4;

/**
 * @author Yanzhan Gou
 * @date 2019-09-16 22:08:51
 */
class Outer {
    String out_string = "String in Outer";
    void useIner(){
        Iner in = new Iner();
        in.print();
    }
    class Iner{
        void print(){
            System.out.println("Iner.print()");
            System.out.println("use\'"+ out_string +"\'");
        }
    }
}
