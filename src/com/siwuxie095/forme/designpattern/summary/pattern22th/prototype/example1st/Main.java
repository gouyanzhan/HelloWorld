package com.siwuxie095.forme.designpattern.summary.pattern22th.prototype.example1st;

/**
 * @author Jiajing Li
 * @date 2019-11-11 22:13:12
 */
public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        MonsterMaker monsterMaker = new MonsterMaker();
        Monster monster = monsterMaker.makeRandomMonster();
        System.out.println(monster.getClass().getSimpleName());
    }

}
