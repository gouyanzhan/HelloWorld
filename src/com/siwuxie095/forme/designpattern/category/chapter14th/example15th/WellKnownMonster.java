package com.siwuxie095.forme.designpattern.category.chapter14th.example15th;

/**
 * 著名的怪兽
 *
 * @author Jiajing Li
 * @date 2019-11-11 22:25:49
 */
class WellKnownMonster extends Monster {

    @Override
    protected Monster clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
