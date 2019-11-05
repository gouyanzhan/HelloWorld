package com.siwuxie095.forme.designpattern.summary.pattern8th.adapter.example1st;

/**
 * @author Jiajing Li
 * @date 2019-11-04 15:33:53
 */
public class Main {

    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        DuckTestDrive.testDuck(duck);

        System.out.println();

        Turkey turkey = new WildTurkey();
        TurkeyAdapter turkeyAdapter = new TurkeyAdapter(turkey);
        DuckTestDrive.testDuck(turkeyAdapter);
    }



}
