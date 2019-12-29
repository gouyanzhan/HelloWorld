package com.siwuxie095.forme.designpattern.category.chapter7th.example1st;

/**
 * 野火鸡（被适配者接口）
 *
 * @author Jiajing Li
 * @date 2019-11-04 15:30:33
 */
class WildTurkey implements Turkey {

    @Override
    public void gobble() {
        System.out.println("Gobble");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying a short distance");
    }
}
