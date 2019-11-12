package com.siwuxie095.forme.designpattern.summary.pattern22th.prototype.example1st;

/**
 * 怪兽注册表
 *
 * @author Jiajing Li
 * @date 2019-11-11 22:22:05
 */
class MonsterRegistry {

    private static Monster monster = new DynamicGeneratedMonster();

    static Monster getMonster() throws CloneNotSupportedException {
        return monster.clone();
    }
}
