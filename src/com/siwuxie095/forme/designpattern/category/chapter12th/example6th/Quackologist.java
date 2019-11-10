package com.siwuxie095.forme.designpattern.category.chapter12th.example6th;

/**
 * 呱呱叫学家（观察者）
 *
 * @author Jiajing Li
 * @date 2019-11-10 11:42:22
 */
class Quackologist implements Observer {

    @Override
    public void update(Observable duck) {
        System.out.println("Quackologist: " + duck.getClass().getSimpleName() + " just quacked.");
    }
}
