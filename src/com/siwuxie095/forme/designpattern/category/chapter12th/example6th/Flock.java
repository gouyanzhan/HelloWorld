package com.siwuxie095.forme.designpattern.category.chapter12th.example6th;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 鸭群
 *
 * @author Jiajing Li
 * @date 2019-11-10 10:48:52
 */
class Flock implements Quackable {

    /*
     * 组合对象和个别对象需要实现相同的接口。组合对象 即 Flock。个别对象 即 Quackable。
     */

    /**
     * 在每个 Flock 中，用 List 记录属于这个 Flock 的 Quackable 对象。
     */
    private List<Quackable> quackers = new ArrayList<>();

    void add(Quackable quacker) {
        quackers.add(quacker);
    }

    /**
     * 这里偷偷使用了迭代器模式
     */
    @Override
    public void quack() {
        Iterator iterator = quackers.iterator();
        while (iterator.hasNext()) {
            // 如果 quacker 是个别对象，则直接调用对应方法；如果 quacker 是组合对象，则进行递归调用。
            Quackable quacker = (Quackable) iterator.next();
            quacker.quack();
        }
    }

    @Override
    public void registerObserver(Observer observer) {
        Iterator iterator = quackers.iterator();
        while (iterator.hasNext()) {
            Quackable quacker = (Quackable) iterator.next();
            quacker.registerObserver(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        Iterator iterator = quackers.iterator();
        while (iterator.hasNext()) {
            Quackable quacker = (Quackable) iterator.next();
            quacker.removeObserver(observer);
        }
    }

    /**
     * 每个 Quackable 都负责自己通知观察者，这样，Flock 就不必操心了。
     * 当 Flock 将 quack() 委托给内部的每一个 Quackable 时，就是调
     * 用 notifyObservers() 的时机。
     */
    @Override
    public void notifyObservers() {
        // 空实现
    }
}
