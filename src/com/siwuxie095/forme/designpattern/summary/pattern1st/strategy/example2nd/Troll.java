package com.siwuxie095.forme.designpattern.summary.pattern1st.strategy.example2nd;

/**
 * 妖怪
 *
 * @author Jiajing Li
 * @date 2019-08-07 22:00:53
 */
class Troll extends Character {

    Troll() {
        weaponBehavior = new AxeBehavior();
    }

    @Override
    void fight() {
        weaponBehavior.useWeapon();
    }
}
