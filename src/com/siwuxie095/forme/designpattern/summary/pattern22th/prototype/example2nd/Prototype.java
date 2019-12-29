package com.siwuxie095.forme.designpattern.summary.pattern22th.prototype.example2nd;

/**
 * 原型
 *
 * @author Jiajing Li
 * @date 2019-11-11 22:49:01
 */
abstract class Prototype implements Cloneable {

    @Override
    protected Prototype clone() throws CloneNotSupportedException {
        return (Prototype) super.clone();
    }
}
