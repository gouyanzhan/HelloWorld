package com.siwuxie095.forme.designpattern.summary.pattern1st.strategy.example2nd;

/**
 * 国王
 *
 * @author Jiajing Li
 * @date 2019-08-07 21:50:09
 */
class King extends Character {

    King() {
        weaponBehavior = new SwordBehavior();
    }

    @Override
    void fight() {
        weaponBehavior.useWeapon();
    }
}
