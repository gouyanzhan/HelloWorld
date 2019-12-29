package com.siwuxie095.forme.designpattern.summary.pattern21th.memento.example1st;

/**
 * 游戏
 *
 * @author Jiajing Li
 * @date 2019-11-11 21:49:59
 */
class Game {

    private String state;

    Game(String state) {
        this.state = state;
    }

    /**
     * 保存状态
     */
    GameMemento saveState() {
        return new GameMemento(state);
    }

    /**
     * 恢复状态
     */
    void restoreState(GameMemento memento) {
        this.state = memento.getState();
    }

    String getState() {
        return state;
    }

    void setState(String state) {
        this.state = state;
    }

}
