package com.siwuxie095.forme.designpattern.summary.pattern1st.strategy.example2nd;

/**
 * 骑士
 *
 * @author Jiajing Li
 * @date 2019-08-07 21:59:40
 */
class Knight extends Character {

    Knight() {
        weaponBehavior = new BowAndArrowBehavior();
    }

    @Override
    void fight() {
        weaponBehavior.useWeapon();
    }

}
