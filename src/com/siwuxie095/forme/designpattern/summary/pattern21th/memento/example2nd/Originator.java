package com.siwuxie095.forme.designpattern.summary.pattern21th.memento.example2nd;

/**
 * 发起者
 *
 * @author Jiajing Li
 * @date 2019-11-11 22:06:49
 */
class Originator {

    private String state;

    String getState() {
        return state;
    }

    void setState(String state) {
        this.state = state;
    }

    /**
     * 创建备忘录，将状态保存到备忘录
     */
    Memento createMemento() {
        return new Memento(state);
    }

    /**
     * 恢复备忘录，从备忘录中将状态恢复出来
     */
    void restoreMemento(Memento memento) {
        state = memento.getState();
    }
}
