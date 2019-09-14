package com.siwuxie095.forme.designpattern.summary.pattern1st.strategy.example2nd;

/**
 * @author Jiajing Li
 * @date 2019-08-07 22:01:38
 */
public class Main {

    public static void main(String[] args) {
        Character king = new King();
        king.fight();
        System.out.println();

        Character queen = new Queen();
        queen.fight();
        System.out.println();

        Character knight = new Knight();
        knight.fight();
        System.out.println();

        Character troll = new Troll();
        troll.fight();
        troll.setWeaponBehavior(new KnifeBehavior());
        troll.fight();
        System.out.println();
    }

}
