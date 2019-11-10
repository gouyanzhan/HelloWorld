package com.siwuxie095.forme.designpattern.category.chapter12th.example5th;

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
}
