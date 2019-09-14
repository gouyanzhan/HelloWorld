package com.siwuxie095.forme.designpattern.summary.pattern1st.strategy.example2nd;

/**
 * 宝剑挥舞
 *
 * @author Jiajing Li
 * @date 2019-08-07 21:50:56
 */
class SwordBehavior implements WeaponBehavior {

    @Override
    public void useWeapon() {
        System.out.println("用宝剑挥舞");
    }
}
