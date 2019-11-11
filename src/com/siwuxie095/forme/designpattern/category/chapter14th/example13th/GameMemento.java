package com.siwuxie095.forme.designpattern.category.chapter14th.example13th;

/**
 * 游戏备忘录
 *
 * @author Jiajing Li
 * @date 2019-11-11 21:47:41
 */
class GameMemento {

    /**
     * 游戏状态
     */
    private String state;

    GameMemento(String state) {
        this.state = state;
    }

    String getState() {
        return state;
    }

    void setState(String state) {
        this.state = state;
    }
}
