package com.siwuxie095.forme.designpattern.category.chapter14th.example15th;

/**
 * 怪兽
 *
 * @author Jiajing Li
 * @date 2019-11-11 22:21:03
 */
abstract class Monster implements Cloneable {

    @Override
    protected Monster clone() throws CloneNotSupportedException {
        return (Monster) super.clone();
    }
}
