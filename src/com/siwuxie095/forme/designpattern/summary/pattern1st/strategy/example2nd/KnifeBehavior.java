package com.siwuxie095.forme.designpattern.summary.pattern1st.strategy.example2nd;

/**
 * 匕首刺杀
 *
 * @author Jiajing Li
 * @date 2019-08-07 21:51:43
 */
class KnifeBehavior implements WeaponBehavior {

    @Override
    public void useWeapon() {
        System.out.println("用匕首刺杀");
    }
}
