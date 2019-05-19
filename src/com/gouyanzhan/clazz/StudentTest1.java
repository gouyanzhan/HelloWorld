package com.gouyanzhan.clazz;

/**
 * @author Yanzhan Gou
 * @date 2019-03-21 11:37:12
 */
public class StudentTest1 {
    public static void main(String[] args){
        String[] categoryArr = new String[]{"养乐多","蒙牛大果粒","娃哈哈"};
        int[] singleCountArr = new int[]{1,1,1};
        double[] priceArr = new double[]{2.5,3,5};
        Student1 s = new Student1(categoryArr,singleCountArr,priceArr);
        s.pay("养乐多",10);
        s.pay("蒙牛大果粒",10);
        s.pay("娃哈哈",10);
        s.pay("养乐多",2.5);
        s.pay("蒙牛大果粒",5);




    }

}
