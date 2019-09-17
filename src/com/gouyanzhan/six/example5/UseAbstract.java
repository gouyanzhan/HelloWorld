package com.gouyanzhan.six.example5;

/**
 * @author Yanzhan Gou
 * @date 2019-07-21 16:48:13
 */
public class UseAbstract {
    public static void main(String[] args){
        Animal animal1 = new Fish();
        animal1.breath();
        Integer a = 1;
        Integer c = 1;
        int b = 1;
        a.toString();
        a.equals(c);
        int d = a + c;
        int e = Integer.sum(a, c);
        Integer.toString(1);

        int f = Integer.max(1, 2);
        int g = Math.max(1, 2);

        int h = Integer.parseInt("123-");
        Integer i = Integer.valueOf("123");

        // 2
        // 1
        //b.toString
        Animal animal2 = new Tiger();
        animal2.breath();
     //   Animal animal3 = new Animal();
        ((Fish)animal1).swim();
        //((Tiger)animal1).tigerRun();
        ((Tiger)animal2).tigerRun();
        //匿名内部类
        Animal animal4 = new Animal() {
            @Override
            void breath() {
                System.out.println("狗是用肺呼吸的");
            }
        };
        animal4.breath();
    }

}
