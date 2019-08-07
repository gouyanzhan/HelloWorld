package com.siwuxie095.forme.designpattern.summary.pattern1st.strategy.example2nd;

/**
 * 王后
 *
 * @author Jiajing Li
 * @date 2019-08-07 21:58:23
 */
class Queen extends Character {

    Queen() {
        weaponBehavior = new KnifeBehavior();
    }

    @Override
    void fight() {
        weaponBehavior.useWeapon();
    }
}
