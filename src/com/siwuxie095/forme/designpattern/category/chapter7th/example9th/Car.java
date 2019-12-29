package com.siwuxie095.forme.designpattern.category.chapter7th.example9th;

/**
 * 汽车
 *
 * @author Jiajing Li
 * @date 2019-11-04 23:44:20
 */
class Car {

    /**
     * 这是对象的一个组件，它的方法可以被调用
     */
    private Engine engine;

    Car() {
        engine = new Engine();
    }

    void start(Key key) {
        // 在这里创建了一个新的对象，它的方法可以被调用
        Doors doors = new Doors();
        // 被当作参数传进来的对象，它的方法可以被调用
        boolean authorized = key.turns();

        if (authorized) {
            engine.start();
            // 可以调用同一个对象内的本地方法（local method）
            updateDashboardDisplay();
            doors.lock();
        }

    }

    private void updateDashboardDisplay() {
        // 更新显示
    }
}
