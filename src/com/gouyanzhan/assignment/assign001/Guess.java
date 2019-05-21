package com.gouyanzhan.assignment.assign001;

/**
 * @author Yanzhan Gou
 * @date 2019-05-21 16:06:26
 */
public class Guess {
    int num;
    int a;
    public void check(int a){
        int num = 100;
        if (a > num){
            System.out.println("您猜的数字太大了");
        }else if (a < num) {
            System.out.println("您猜的数字太小了");
        }else{
            System.out.println("恭喜您！猜对了～");

        }
    }


}
