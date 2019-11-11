package com.siwuxie095.forme.designpattern.category.chapter14th.example13th;

/**
 * 客户
 *
 * @author Jiajing Li
 * @date 2019-11-11 21:47:14
 */
class Client {

    void play() {
        Game game = new Game("#1");
        game.setState("#2");
        game.setState("#3");
        game.setState("#4");
        // 手动存档
        GameMemento memento = game.saveState();
        game.setState("#5");
        game.setState("#6");
        // 恢复存档
        game.restoreState(memento);
        System.out.println(game.getState());
    }

}
