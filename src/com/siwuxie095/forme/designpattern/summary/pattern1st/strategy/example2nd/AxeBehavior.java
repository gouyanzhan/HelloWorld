package com.siwuxie095.forme.designpattern.summary.pattern1st.strategy.example2nd;

/**
 * 斧头劈砍
 *
 * @author Jiajing Li
 * @date 2019-08-07 21:53:28
 */
class AxeBehavior implements WeaponBehavior {

    @Override
    public void useWeapon() {
        System.out.println("用斧头劈砍");
    }
}
