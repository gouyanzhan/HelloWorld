package com.siwuxie095.forme.designpattern.summary.pattern1st.strategy.example2nd;

/**
 * 弓箭射击
 *
 * @author Jiajing Li
 * @date 2019-08-07 21:52:28
 */
class BowAndArrowBehavior implements WeaponBehavior {

    @Override
    public void useWeapon() {
        System.out.println("用弓箭射击");
    }
}
