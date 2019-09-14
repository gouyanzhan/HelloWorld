package com.siwuxie095.forme.designpattern.summary.pattern1st.strategy.example2nd;

/**
 * 角色
 *
 * @author Jiajing Li
 * @date 2019-08-07 21:47:32
 */
abstract class Character {

    WeaponBehavior weaponBehavior;

    Character() {
    }

    /**
     * 战斗
     */
    abstract void fight();

    void setWeaponBehavior(WeaponBehavior weaponBehavior) {
        this.weaponBehavior = weaponBehavior;
    }
}
