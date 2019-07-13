package com.gouyanzhan.assignment.assign003;

/**
 * @author Yanzhan Gou
 * @date 2019-07-13 21:00:45
 */
public class WuMingFenTest {
    public static void main(String[] args){
        WuMingFen f1 = new WuMingFen("牛肉",3,true);
        WuMingFen f2 = new WuMingFen("牛肉",2);
        WuMingFen f3 = new WuMingFen();
        f1.Check();
        f2.Check();
        f3.Check();
    }

}
