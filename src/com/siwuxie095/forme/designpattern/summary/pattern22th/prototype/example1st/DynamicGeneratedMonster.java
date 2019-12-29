package com.siwuxie095.forme.designpattern.summary.pattern22th.prototype.example1st;

/**
 * 动态生成的怪兽
 *
 * @author Jiajing Li
 * @date 2019-11-11 22:29:56
 */
class DynamicGeneratedMonster extends Monster {

    @Override
    protected Monster clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
