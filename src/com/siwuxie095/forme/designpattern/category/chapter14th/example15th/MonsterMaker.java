package com.siwuxie095.forme.designpattern.category.chapter14th.example15th;

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
