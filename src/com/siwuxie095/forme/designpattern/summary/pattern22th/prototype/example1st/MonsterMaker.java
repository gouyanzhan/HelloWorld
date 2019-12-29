package com.siwuxie095.forme.designpattern.summary.pattern22th.prototype.example1st;

/**
 * 怪兽制作者
 *
 * @author Jiajing Li
 * @date 2019-11-11 22:22:05
 */
class MonsterMaker {

    Monster makeRandomMonster() throws CloneNotSupportedException {
        return MonsterRegistry.getMonster();
    }

}
