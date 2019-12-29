package com.siwuxie095.forme.designpattern.summary.pattern21th.memento.example2nd;

/**
 * 备忘录
 *
 * @author Jiajing Li
 * @date 2019-11-11 22:05:35
 */
class Memento {

    /**
     * 状态
     */
    private String state;

    Memento(String state) {
        this.state = state;
    }

    String getState() {
        return state;
    }

    void setState(String state) {
        this.state = state;
    }
}
